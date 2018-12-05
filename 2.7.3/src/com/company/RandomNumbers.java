package com.company;

import com.smartxls.ChartShape;
import com.smartxls.WorkBook;

import java.io.*;
import java.text.NumberFormat;
import java.util.Random;

    public class RandomNumbers {
        private final int count;
        private final int mean;
        private final int standardDeviation;
        DataOutputStream binaryOutputStream;
        BufferedReader binaryInputStream;
        FileWriter fileWriter;
        PrintWriter textOutputStream;


        public RandomNumbers(int count, int mean, int standardDeviation) throws FileNotFoundException, IOException {
            assert (standardDeviation >= 0);
            WorkBook workBook = new WorkBook();
            this.count = count;
            this.mean = mean;
            this.standardDeviation = standardDeviation;
            this.binaryOutputStream = new DataOutputStream(new FileOutputStream("binout.dat"));
            this.binaryInputStream = new BufferedReader(new InputStreamReader(new FileInputStream("binout.dat")));
            this.fileWriter = new FileWriter("textout.txt");
            this.textOutputStream = new PrintWriter(getFileWriter());

            for (int i = 0; i < getCount(); i++) {
                double randomNumber = generateRandomNumber();
                String randomNumberString = format(randomNumber);
                writeLineToBinaryFile(randomNumberString);
            }
            try {
                for (int row = 1; row <= getCount(); row++) {
                    double randomNumber = generateRandomNumber();
                    String randomNumberString = format(randomNumber);
                    workBook.setText(row, 1, randomNumberString);
                }
                for (int row = 2; row <= getCount()+1; row++) {
                    workBook.setFormula(row, 2, "Value($B$"+row+")");
                }
                workBook.insertSheets(0, 1);//insert sheet from left
                workBook.setSheet(0);//select the new created sheet
                workBook.setSheetName(0, "ChartSheet");

                ChartShape chart = workBook.addChartSheet(0);//add chart
                //Open your 3rd eye
                //chart.setChartType(ChartShape.Radar);
                //chart.setChartType(ChartShape.Column);
                chart.setChartType(ChartShape.Line);
                chart.setPlotStacked(true);//set plot serires stacked
                chart.setBarGapRatio(10);

                chart.addSeries();
                //chart.setSeriesName(0, "My Series number 1");

                chart.setSeriesYValueFormula(0, "Sheet1!$C$3:$C$52");
                //chart.setSeriesXValueFormula(0, "Sheet1!$B$2:$B$10001");

                //set axis title
                chart.setAxisTitle(ChartShape.XAxis, 0, "X-axis data");
                chart.setAxisTitle(ChartShape.YAxis, 0, "Y-axis data");

                //set series name
                chart.setSeriesName(0, "My Series number 1");

                chart.setTitle("My Chart");

                workBook.writeXLSX("Chartsheet.xlsx");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < getCount(); i++) {
                String line = readLineFromBinaryFile();
                writeLineToTextFile(i, line);
            }
        }

        public void closeDataStreams() throws IOException {
            getBinaryOutputStream().close();
            getBinaryInputStream().close();
            getFileWriter().close();
            getTextOutputStream().close();
        }

        public void writeLineToBinaryFile(String number) throws IOException {
            getBinaryOutputStream().writeChars(number);
            getBinaryOutputStream().writeChar('\n');
        }

        public String readLineFromBinaryFile() throws IOException {
            String result;
            result = getBinaryInputStream().readLine();
            return result;
        }

        public void writeLineToTextFile(int line, String number) throws IOException {
            number = number.replaceAll("\u0000", "");
            getTextOutputStream().print(line + 1);
            getTextOutputStream().print("\u0009");
            getTextOutputStream().println(number);
        }

        public double generateRandomNumber() {
            Random r = new Random();
            Double result = r.nextGaussian() * getStandardDeviation() + getMean();
            return result;
        }

        public String format(double number) {
            String result = NumberFormat.getInstance().format(number);
            return result;
        }

        public int getCount() {
            return count;
        }

        public int getMean() {
            return mean;
        }

        public int getStandardDeviation() {
            return standardDeviation;
        }

        public DataOutputStream getBinaryOutputStream() {
            return binaryOutputStream;
        }

        public BufferedReader getBinaryInputStream() {
            return binaryInputStream;
        }

        public PrintWriter getTextOutputStream() {
            return textOutputStream;
        }

        public FileWriter getFileWriter() {
            return fileWriter;
        }
    }