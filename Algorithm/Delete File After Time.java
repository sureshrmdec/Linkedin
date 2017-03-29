
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
