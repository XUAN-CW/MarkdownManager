package com.example.markdownmanager.utils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author XUAN
 * @date 2021/7/4 - 13:35
 */
@Component
public class GetMarkdown {

    /**
     * 获取 dir 文件夹下所有的 .md 文件
     * @param dir 要扫描的文件夹
     * @return java.util.List<java.io.File>
     */
    public List<File> getFileBySuffix(File dir){
        List<File> fileList = new LinkedList<>();
        recursiveTraversalFolder(dir,fileList);
        return fileList;
    }

    /**
     * 获取 path 文件夹下所有的 .md 文件
     * @param path 要扫描的文件夹
     * @return java.util.List<java.io.File>
     */
    public List<File> getFileBySuffix(String path){
        return getFileBySuffix(new File(path));
    }


    /**
     * 递归查找文件夹下所有的 .md 文件
     * <p>
     * 如果扫描的文件夹是一个 git 仓库，那么将只扫描纳入版本管理的文件，而不是每个文件都扫描
     * @param currentDir 当前递归目录
     * @param fileList .md 文件列表
     * @return void
     */
    private void recursiveTraversalFolder(File currentDir,List<File> fileList) {
        //1. 是 git 仓库
        try {
            // 没有抛异常就说明这是个 Repository
            // 对于 git 仓库，我们有  git 仓库的处理方法
            // 处理完后直接 return
            List<File> markDownFiles = GetMarkdownFromRepository(currentDir);
            fileList.addAll(markDownFiles);
            return;
        } catch (RepositoryNotFoundException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. 是普通文件夹
        File[] fileArr = currentDir.listFiles(pathname -> {
            if(!pathname.isDirectory()){
                return pathname.getName().endsWith(".md");
            }
            return true;
        });
        if (null != fileArr && fileArr.length != 0) {
            for (File file : fileArr) {
                // 是文件夹，继续往下递归
                if (file.isDirectory()) {
                    recursiveTraversalFolder(file,fileList);
                }else {
                    fileList.add(file);
                }
            }
        }
    }

    /**
     * 获取 git 管理的文件
     * @param currentDir 当前目录
     * @return java.util.List<java.io.File>
     */
    private List<File> GetMarkdownFromRepository(File currentDir) throws IOException {
        Git git = Git.open(currentDir);
        Repository repository = git.getRepository();
        DirCache index = DirCache.read(repository);
        List<File> fileList = new LinkedList<>();
        for (int i = 0; i < index.getEntryCount(); i++) {
            File markdownFile = new File(repository.getWorkTree().getAbsolutePath()+File.separator+index.getEntry(i).getPathString());
            if(markdownFile.getName().endsWith(".md")){
                fileList.add(markdownFile);
            }
        }
        return  fileList;
    }

}
