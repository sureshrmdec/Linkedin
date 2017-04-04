
    private File[] getFilss() {


        File folder = new File("c:");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < (listOfFiles != null ? listOfFiles.length : 0); i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

        return listOfFiles;

    }


    private void removeFile(File[] files, long epochTime) {


        try {
            for (File f : files) {

                if (f.lastModified() < epochTime) {
                    boolean delete = f.delete();

                    System.out.println(delete);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        File f = null;
        String path;
        long millisec;
        boolean bool = false;


        try {

            // create new file
            f = new File("l:/download/123.txt");

            // true if the file path is a file, else false
            bool = f.exists();

            // if path exists
            if (bool) {
                // returns the time file was last modified
                millisec = f.lastModified();

                // date and time
                Date dt = new Date(millisec);

                // path
                path = f.getPath();

                // print
                System.out.print(path + " last modified at: " + dt);
            }


        } catch (Exception e) {

            // if any error occurs
            e.printStackTrace();
        }
    }
