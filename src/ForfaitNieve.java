import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ForfaitNieve {
    static String BOLD = "\033[1m";
    static String UNDERLINE = "\033[4m";
    static String END = "\033[0m";

    static void calcular(long days, int daysLow, int daysHigh, int daysSpecial) {

        int col = 0;
        boolean dis = true;
        boolean nume = true;
        int cont = 0;
        double des = 0;
        double preciBaj;
        double preciAlt;
        double preciEsp;
        double total;
        double vari = 0;

        Scanner teclado = new Scanner(System.in);
        System.out.println();

        while (cont == 0) {

            System.out.print("Colectivo (Benj-1/Inf-2/Adul-3/Sen-4/SenP-5): ");
            col = teclado.nextInt();

            if (col > 5) {
                System.out.println("Introduzca un valor v\u00e1lido");
            } else {cont++;}
        }


        cont = 0;
        teclado.nextLine();
        while (cont == 0) {
            System.out.println();
            System.out.print("Discapacitado (S\u00ed/No): ");
            String sdis = teclado.nextLine();

            if (sdis.equals("Si") || sdis.equals("si")) {
                dis = true;
                cont++;
            } else if (sdis.equals("No") || sdis.equals("no")) {
                dis = false;
                cont++;
            } else {System.out.println("Introduzca Si o No"); System.out.println();}
        }

        cont = 0;
        while (cont == 0) {
            System.out.print("Familia numerosa (S\u00ed/No): ");
            String snume = teclado.nextLine();

            if (snume.equals("Si") || snume.equals("si")) {
                nume = true;
                cont++;
            } else if (snume.equals("No") || snume.equals("no")) {
                nume = false;
                cont++;
            } else {System.out.println("Introduzca Si o No"); System.out.println();}
        }

        switch (col) {
            case 1 -> des = 0.4;
            case 2 -> des = 0.35;
            case 3 -> des = 0;
            case 4 -> des = 0.2;
            case 5 -> des = 0.3;
        }

        if (dis) {
            des = des+0.05;
        }
        if (nume) {
            des = des+0.05;
        }

        System.out.println();
        System.out.println("Con los datos suministrados:");
        preciBaj = daysLow * (50*(1-des));
        System.out.println("\t"+daysLow+" d\u00edas Temporada baja: "+preciBaj+"\u20ac ("+50*(1-des)+"\u20ac/d\u00eda)");
        preciAlt = daysHigh * (50*(1-des+0.02));
        System.out.println("\t"+daysHigh+" d\u00edas Temporada alta: "+preciAlt+"\u20ac ("+50*(1-des+0.02)+"\u20ac/d\u00eda)");
        preciEsp = daysSpecial * (50*(1-des+0.03));
        System.out.println("\t"+daysSpecial+" d\u00edas Temporada especial: "+preciEsp+"\u20ac ("+50*(1-des+0.03)+"\u20ac/d\u00eda)");
        System.out.println();

        total = preciBaj+preciAlt+preciEsp;

        double [][] paquete = new double[5][5];

        paquete [0] [0] = 265;
        paquete [0] [1] = 284.5;
        paquete [0] [2] = 437.50;
        paquete [0] [3] = 350;
        paquete [0] [4] = 337.50;
        paquete [1] [0] = 390;
        paquete [1] [1] = 420;
        paquete [1] [2] = 646.50;
        paquete [1] [3] = 517;
        paquete [1] [4] = 481.25;
        paquete [2] [0] = 510;
        paquete [2] [1] = 551.50;
        paquete [2] [2] = 848.50;
        paquete [2] [3] = 679;
        paquete [2] [4] = 645;
        paquete [3] [0] = 495;
        paquete [3] [1] = 534.80;
        paquete [3] [2] = 822.85;
        paquete [3] [3] = 658;
        paquete [3] [4] = 635;
        paquete [4] [0] = 710;
        paquete [4] [1] = 764;
        paquete [4] [2] = 1175.50;
        paquete [4] [3] = 940;
        paquete [4] [4] = 893;

        col = col-1;

        if (dis) {
            vari = vari+0.05;
        }
        if (nume) {
            vari = vari+0.05;
        }

        if (days > 17) {
            if (paquete [4][col]*(1-vari) < total) {
                System.out.println((("Se le recomienda la adquisici\u00f3n de un Forfait de temporada L-V que le sale a "
                        + paquete[4][col]*(1-vari) + "\u20ac y as\u00ed se ahorra " + (total-paquete[4][col]*(1-vari)) + "\u20ac")));
            } else if (paquete [3][col]*(1-vari) < total) {
                System.out.println((("Se le recomienda la adquisici\u00f3n de un Forfait de temporada que le sale a "
                        + paquete[3][col]*(1-vari) + "\u20ac y as\u00ed se ahorra " + (total-paquete[3][col]*(1-vari)) + "\u20ac")));
            } else {System.out.println("Se le recomienda la adquisici\u00f3n de un Forfait de "+days+" d\u00edas sueltos que le sale a "+total+"\u20ac");}
        } else if (days < 17 && days > 13) {
            if (paquete [2][col]*(1-vari) < total) {
                System.out.println((("Se le recomienda la adquisici\u00f3n de un Forfait de 20 d\u00edas que le sale a "
                        + paquete[2][col]*(1-vari) + "\u20ac y as\u00ed se ahorra " + (total-paquete[2][col]*(1-vari)) + "\u20ac")));
            } else {System.out.println("Se le recomienda la adquisici\u00f3n de un Forfait de "+days+" d\u00edas sueltos que le sale a "+total+"\u20ac");}

        } else {
            if (paquete[1][col]*(1-vari) < total) {
                System.out.println((("Se le recomienda la adquisici\u00f3n de un Forfait de 15 d\u00edas que le sale a "
                        + paquete[1][col]*(1-vari) + "\u20ac y as\u00ed se ahorra " + (total-paquete[1][col]*(1-vari)) + "\u20ac")));
            } else {
                if (paquete[0][col]*(1-vari) < total) {
                    System.out.println((("Se le recomienda la adquisici\u00f3n de un Forfait de 10 d\u00edas que le sale a "
                            + paquete[0][col]*(1-vari) + "\u20ac y as\u00ed se ahorra " + (total-paquete[0][col]*(1-vari)) + "\u20ac")));
                } else {
                    System.out.println("Se le recomienda la adquisici\u00f3n de un Forfait de " + days + " d\u00edas sueltos que le sale a " + total + "\u20ac");
                }
            }
        }
    }

    public static void main(String[] args) {

        ForfaitNieve metodos = new ForfaitNieve();

        System.out.println("\n\t\t" + BOLD + UNDERLINE + "PROGRAMA FORFAIT NIEVE\n" + END);
        System.out.println();

        final Integer DAY_HIGH = 1;
        final Integer DAY_LOW = 2;
        final Integer DAY_SPECIAL = 3;
        final Integer MONTH_NOVEMBER = 11;
        final Integer MONTH_DECEMBER = 12;
        final Integer MONTH_JANUARY = 01;
        final Integer MONTH_FEBRUARY = 02;
        final Integer MONTH_MARCH = 03;
        final Integer MONTH_APRIL = 04;
        final Integer MONTH_MAY = 05;

        final List<Integer> daysTypesOfNovember = Arrays.asList(DAY_LOW, DAY_LOW, DAY_LOW);

        final List<Integer> daysTypesOfDecember = Arrays.asList(DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH,
                DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW,
                DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_SPECIAL, DAY_SPECIAL,
                DAY_SPECIAL, DAY_SPECIAL, DAY_SPECIAL, DAY_HIGH);

        final List<Integer> daysTypesOfJanuary = Arrays.asList(DAY_HIGH, DAY_SPECIAL, DAY_SPECIAL, DAY_SPECIAL,
                DAY_SPECIAL, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH,
                DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH);

        final List<Integer> daysTypesOfFebruary = Arrays.asList(DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH,
                DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH,
                DAY_HIGH, DAY_SPECIAL, DAY_SPECIAL);

        final List<Integer> daysTypesOfMarch = Arrays.asList(DAY_SPECIAL, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW,
                DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_HIGH,
                DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH);

        final List<Integer> daysTypesOfApril = Arrays.asList(DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_HIGH, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW,
                DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW, DAY_LOW,
                DAY_LOW, DAY_LOW);

        final List<Integer> daysTypesOfMay = Arrays.asList(DAY_LOW, DAY_LOW);


        // Creamos el scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println(BOLD + "Entrada" + END);

        // Preguntamos y leemos el día de entrada
        System.out.print("D\u00eda: ");
        String dayStart = scanner.nextLine();

        // Preguntamos y leemos el mes de entrada
        System.out.print("Mes: ");
        String monthStart = scanner.nextLine();

        // Preguntamos y leemos el año de entrada
        System.out.print("A\u00f1o: ");
        String yearStart = scanner.nextLine();
        System.out.println(BOLD + "Salida" + END);

        // Preguntamos y leemos el día de salida
        System.out.print("D\u00eda: ");
        String dayEnd = scanner.nextLine();

        // Preguntamos y leemos el mes de salida
        System.out.print("Mes: ");
        String monthEnd = scanner.nextLine();

        // Preguntamos y leemos el año de salida
        System.out.print("A\u00f1o: ");
        String yearEnd = scanner.nextLine();

        // Creamos el formatter que pasará las entradas de datos a fecha
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Parseamos los inputs de entrada a fechas de inicio y de fin. En caso de algún
        // error informamos del mismo y paramos la ejecución
        Date dateStart = null;
        Date dateEnd = null;

        try {
            dateStart = myFormat.parse(dayStart + "/" + monthStart + "/" + yearStart);
            dateEnd = myFormat.parse(dayEnd + "/" + monthEnd + "/" + yearEnd);
        } catch (ParseException e) {
            System.out.println("Las fechas introducidas no son v\u00e1lidas");
            return;
        }

        Calendar minDate = Calendar.getInstance();
        minDate.set(Calendar.YEAR, 2020);
        minDate.set(Calendar.MONTH, 10);
        minDate.set(Calendar.DAY_OF_MONTH, 27);

        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.YEAR, 2021);
        maxDate.set(Calendar.MONTH, 4);
        maxDate.set(Calendar.DAY_OF_MONTH, 3);

        if (dateStart.before(minDate.getTime()) || dateEnd.after(maxDate.getTime())) {
            System.out.println("Las fechas deben estar comprendidas entre el 28 de Noviembre de 2020 y el 2 de Mayo de 2021");
            return;
        }


        // Calculamos la diferencia de tiempo entre ambas fechas
        long diff = dateEnd.getTime() - dateStart.getTime();

        // Pasamos esa diferencia de tiempo a días
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        // Creamos el calendario que usaremos para recorrer los días
        Calendar calendar = Calendar.getInstance();

        // Iniciamos el calendario con la fecha de inicio
        calendar.setTime(dateStart);

        // Creamos el calendario que usaremos para tener la fecha de fin
        Calendar endCalendar = Calendar.getInstance();

        // Iniciamos el calendario con la fecha de fin
        endCalendar.setTime(dateEnd);

        // Creamos las variables donde almacenaremos el numero de dia de cada tipo
        int daysHigh = 0;
        int daysLow = 0;
        int daysSpecial = 0;

        // Mientras la fecha actual no sea mayor que la fecha de fin
        while (calendar.before(endCalendar)) {

            // Obtenemos el mes y día de la fecha actual. Debemos sumar 1 al mes ya que
            // empieza en 0. No obtenemos el año ya que no tiene relevancia
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;

            //es especial porque para nosotros empieza noviembre el dia 28
            if (month == MONTH_NOVEMBER.intValue()) {
                if (day == 28) {
                    day = 1;

                } else if (day == 29) {
                    day = 2;
                } else if (day == 30) {
                    day = 3;
                }

                int typeOfDay = daysTypesOfNovember.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            }

            // Comprobamos que mes es para saber en que listado debemos mirar el tipo de día
            else if (month == MONTH_DECEMBER.intValue()) {
                // Obtenemos el tipo de día. Debemos restar uno ya que el listado empieza en 0 y
                // los días en 1
                int typeOfDay = daysTypesOfDecember.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            } else if (month == MONTH_JANUARY.intValue()) {
                // Obtenemos el tipo de día. Debemos restar uno ya que el listado empieza en 0 y
                // los días en 1
                int typeOfDay = daysTypesOfJanuary.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            } else if (month == MONTH_FEBRUARY.intValue()) {
                // Obtenemos el tipo de día. Debemos restar uno ya que el listado empieza en 0 y
                // los días en 1
                int typeOfDay = daysTypesOfFebruary.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            } else if (month == MONTH_MARCH.intValue()) {
                // Obtenemos el tipo de día. Debemos restar uno ya que el listado empieza en 0 y
                // los días en 1
                int typeOfDay = daysTypesOfMarch.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            } else if (month == MONTH_APRIL.intValue()) {
                // Obtenemos el tipo de día. Debemos restar uno ya que el listado empieza en 0 y
                // los días en 1
                int typeOfDay = daysTypesOfApril.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            } else if (month == MONTH_MAY.intValue()) {
                // Obtenemos el tipo de día. Debemos restar uno ya que el listado empieza en 0 y
                // los días en 1

                int typeOfDay = daysTypesOfMay.get(day - 1);
                if (typeOfDay == DAY_HIGH.intValue()) {
                    daysHigh++;

                } else if (typeOfDay == DAY_LOW.intValue()) {
                    daysLow++;
                } else if (typeOfDay == DAY_SPECIAL.intValue()) {
                    daysSpecial++;
                }

            }

            // Aumentamos en 1 la fecha
            calendar.add(Calendar.DATE, 1);
        }

        // Imprimimos los datos resultantes
        if (days > 0) {
            System.out.println("\t\t\t" + "Son un total de " + days + " d\u00edas.");
        }
        if (daysLow > 0) {
            System.out.println("\t\t\t" + daysLow + " d\u00edas son de temporada baja.");
        }
        if (daysHigh > 0) {
            System.out.println("\t\t\t" + daysHigh + " d\u00edas son de temporada alta.");
        }
        if (daysSpecial > 0) {
            System.out.println("\t\t\t" + daysSpecial + " d\u00edas son de temporada especial.");
        }
        metodos.calcular(days, daysLow, daysHigh, daysSpecial);
    }
}