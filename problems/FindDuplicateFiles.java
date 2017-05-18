import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import java.math.BigInteger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.security.MessageDigest;
import java.security.DigestInputStream;
import java.security.NoSuchAlgorithmException;

import java.nio.file.Path;
import java.nio.file.Paths;


public class FilePaths {

    Path duplicatePath;
    Path originalPath;

    public FilePaths(Path duplicatePath, Path originalPath) {
        this.duplicatePath = duplicatePath;
        this.originalPath  = originalPath;
    }

    public String toString() {
        return "(original: " + originalPath + ", duplicate: " + duplicatePath + ")";
    }
}


public class FileInfo {
    long timeLastEdited;
    Path path;

    public FileInfo(long timeLastEdited, Path path) {
      this.timeLastEdited = timeLastEdited;
      this.path = path;
    }
}


public class findDuplicateFiles {
public List<FilePaths> findDuplicateFiles(Path startingDirectory) {
  Map<String, FileInfo> filesSeenAlready = new HashMap<String, FileInfo>();
  Stack<Path> stack = new Stack<Path>();
  stack.push(startingDirectory);

  List<FilePaths> duplicates = new ArrayList<FilePaths>();

  while (!stack.Empty()) {
    Path currentPath = stack.pop();
    File currentFile = new File(currentPath.toString());

    if (currentFile.isDirectory()) {
      for (File file : currentFile.listFiles()) {
        stack.add(file.toPath());
      }
    } else {

      String fileHash = sampleHashFile(currentPath);
      long currentLastEditTime = currentFile.lastModified();

      if (filesSeenAlready.containsKey(fileHash)) {

        FileInfo fileInfo = filesSeenAlready.get(fileHash);
        long existingLastEditedTime = fileInfo.timeLastEdited;
        Path existingPath = fileInfo.path;

        if (currentLastEditTime > existingLastEditedTime) {
          duplicates.add(new FilePaths(currentPath, existingPath));
        } else {
          duplicates.add(new FilePaths(existingPath, currentPath));
          filesSeenAlready.put(fileHash, new fileInfo(currentLastEditTime, currentPath));
        }

      } else {
        filesSeenAlready.put(fileHash, new FileInfo(currentLastEditTime, currentPath));
      }
    }
  }
  return duplicates;
}


public String sampleHashFile(Path path) {
  final int numBytesToReadPerSample = 4000;
  final long totalBytes = new File(path.toString()).length();

  InputStream inputStream = null;
  MessageDigest digest = null;

  try {
    inputStream = new fileInputStream(path.toString());
    digest = MessageDigest.getInstance("SHA-512");
  } catch (FileNotFoundException e) {
    System.out.println(e);
  } catch (NoSuchAlgorithmException e) {
    System.out.println(e);
  }

  DigestInputStream digestInputStream = new DigestInputStream(inputStream, digest);

  try {

    if (totalBytes < numBytesToReadPerSample * 3) {
      byte[] bytes = new byte[(int) totalBytes];
      digestInputStream.read(bytes);
    } else {
      byte[] bytes = new byte[numBytesToReadPerSample * 3];
      long numBytesBetweenSamples = (totalBytes - numBytesToReadPerSample * 3) / 2;

      for (int n = 0; n < 3; n++) {
        digestInputStream.read(bytes, n * numBytesToReadPerSample, numBytesToReadPerSample);
        digestInputStream.skip(numBytesBetweenSamples);
      }
    }

  } catch (IOException e) {
    System.out.println(e);
  }

  return new BigInteger(1, digest.digest()).toString(16).toString();

}



  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}