package sfc.rce;

import sfc.rce.io.Printer;

public class Arguments {
    static String trainingFile = "";
    static String validationFile = "";
    static Double maxRadius = 3.0;
    static Double decreaseRation = 0.9;

    static void argParse(String[] args){
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-h")){
                Printer.printHelp();
                System.exit(0);
            }

            if (i + 1 == args.length){
                System.err.print("Error: Missing value for " + args[i] + "\n");
                System.exit(1);
            }

            try {
                switch (args[i]) {
                    case "-t":
                        Arguments.trainingFile = args[i + 1];
                        break;
                    case "-v":
                        Arguments.validationFile = args[i + 1];
                        break;
                    case "-R":
                        Arguments.maxRadius = Double.parseDouble(args[i + 1]);
                        break;
                    case "-r":
                        Arguments.decreaseRation = Double.parseDouble(args[i + 1]);
                        break;
                }
                i++;
            }
            catch (NumberFormatException e) {
                System.err.println("Error: Invalid value of " + args[i] + "! Should be floating point number.\n");
                System.exit(1);
            }
        }
    }
}
