package chernyh.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        public class EleventhLesson {
            private static final String A_FILE_PATH = "./testA.txt";
            private static final String B_FILE_PATH = "./testB.txt";
            private static final String C_FILE_PATH = "./testC.txt";
            private static final String LINE_SEPARATOR = "\n";

            public static void main(String[] args) throws IOException {
                createFile(A_FILE_PATH);
                appendLine(A_FILE_PATH, "2");
                appendLine(A_FILE_PATH, "4");
                appendLine(A_FILE_PATH, "6");

                createFile(B_FILE_PATH);
                appendLine(B_FILE_PATH, "3");
                appendLine(B_FILE_PATH, "5");
                appendLine(B_FILE_PATH, "9");

                System.out.println(getLines(A_FILE_PATH));
                mergeFile(A_FILE_PATH, B_FILE_PATH, C_FILE_PATH);
                copyFile(A_FILE_PATH, C_FILE_PATH);
                System.out.println(findFiles("./", ".txt"));
                System.out.println(findInFile("./", "1"));
            }

            private static Boolean createFile(String filePath) {
                boolean result = false;
                File file = new File(filePath);
                try {
                    result = file.createNewFile();
                } catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }

                return result;
                private static List<String> getLines (String filePath){
                    if (StringUtils.isEmpty(filePath))
                        throw new NullPointerException();

                    List<String> list = new ArrayList<>();
                    File file = new File(filePath);
                    try {
                        list.addAll(new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return list;
                }
                private static void appendLine (String filePath, String value){
                    if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(value))
                        throw new NullPointerException();

                    try (FileWriter writer = new FileWriter(filePath, true)) {
                        writer.append(value).append(System.lineSeparator());
                    } catch (Exception exp) {
                        System.out.println(exp.getMessage());
                    }
                }
                private static void mergeFile (String filePathA, String filePathB, String newFilePath){
                    if (StringUtils.isEmpty(filePathA) || StringUtils.isEmpty(filePathB))
                        throw new NullPointerException();

                    List<String> lineList = getLines(filePathA);
                    lineList.addAll(getLines(filePathB));

                    createFile(newFilePath);
                    for (String line : lineList) {
                        appendLine(newFilePath, line);
                        private static void copyFile (String filePathA, String filePathB){
                            if (StringUtils.isEmpty(filePathA) || StringUtils.isEmpty(filePathB))
                                throw new NullPointerException();

                            try (InputStream is = new FileInputStream(filePathA);
                                 OutputStream os = new FileOutputStream(filePathB)) {
                                byte[] buffer = new byte[1024];
                                int length;
                                while ((length = is.read(buffer)) > 0) {
                                    os.write(buffer, 0, length);
                                }
                            } catch (Exception exp) {
                                System.out.println(exp.getMessage());
                                private static List<String> findFiles (String filePath, String find){
                                    if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(find))
                                        throw new NullPointerException();

                                    ArrayList<String> result = new ArrayList<>();

                                    File dir = new File(filePath);
                                    if (!dir.exists() || !dir.isDirectory())
                                        throw new Error("Файл не найден или не является директорией");

                                    File[] files = dir.listFiles();
                                    if (files == null || files.length == 0) {
                                        return result;
                                    }

                                    for (File file : files) {
                                        if (file.getName().contains(find)) {
                                            result.add(file.getName());
                                        }
                                    }

                                    return result;
                                    public static List<String> findInFile (String filePath, String str){
                                        if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(str))
                                            throw new NullPointerException();

                                        File dir = new File(filePath);
                                        if (!dir.exists() || !dir.isDirectory())
                                            throw new Error("Файл не найден или не является директорией");

                                        ArrayList<String> result = new ArrayList<>();

                                        File[] files = dir.listFiles();
                                        if (files == null || files.length == 0) {
                                            return result;
                                        }

                                        for (File file : files) {
                                            if (!file.isFile())
                                                continue;

                                            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                                                String line;
                                                while ((line = reader.readLine()) != null) {
                                                    if (line.contains(str)) {
                                                        result.add(file.getName());
                                                    }
                                                }
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        return result;
                                        // write your code here
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



