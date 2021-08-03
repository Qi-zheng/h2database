package org.h2.test.self;

import org.h2.store.fs.FilePath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.List;


public class QueryEngineStreamPath extends FilePath {

    @Override
    public long size() {
        return 0;
    }

    @Override
    public void moveTo(FilePath newName, boolean atomicReplace) {

    }

    @Override
    public boolean createFile() {
        return false;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<FilePath> newDirectoryStream() {
        return null;
    }

    @Override
    public FilePath toRealPath() {
        return null;
    }

    @Override
    public FilePath getParent() {
        return null;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isAbsolute() {
        return false;
    }

    @Override
    public long lastModified() {
        return 0;
    }

    @Override
    public boolean canWrite() {
        return false;
    }

    @Override
    public void createDirectory() {

    }

    @Override
    public FileChannel open(String mode) throws IOException {
        return null;
    }

    @Override
    public InputStream newInputStream() throws IOException {
        URL url = new URL("http://files.grouplens.org/datasets/movielens/ml-100k/u.data");
        return url.openStream();
    }

    @Override
    public boolean setReadOnly() {
        return false;
    }

    @Override
    public String getScheme() {
        return "talos";
    }

    @Override
    public FilePath getPath(String path) {
        return new QueryEngineStreamPath();
    }
}
