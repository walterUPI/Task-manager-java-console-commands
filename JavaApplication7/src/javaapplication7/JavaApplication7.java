//gestor de tareas
package javaapplication7;

import java.util.Scanner;

public class JavaApplication7 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows, cols = 3, main_menu, id = 1, row = 0, op_id;
        String tasks[][], task;
        char yes_or_no;
        boolean options_loop = true, settask_loop = true, show_loop = true, mod_loop = true;

        System.out.println("=== Welcome to task manager ===");
        System.out.print("How many task u want to save?: ");
        rows = scn.nextInt();
        scn.nextLine();

        //iniciamos la matriz
        tasks = new String[rows][cols];
        while (options_loop) {
            System.out.println("=== TASK MANAGER ===");
            System.out.println("1. Add task");
            System.out.println("2. Show tasks");
            System.out.println("3. Update tasks");
            System.out.println("4. Exit");
            System.out.println("========================");
            System.out.print("Enter the option number that you want: ");
            main_menu = scn.nextInt();
            scn.nextLine();
            System.out.println("=============================================");

            switch (main_menu) {
                case 1:
                    settask_loop = true;
                    while (settask_loop) {
                        System.out.print("What task do you want to add? : ");
                        task = scn.nextLine();
                        setTarea(tasks, task, rows, row, id);
                        row++;
                        id++;
                        System.out.print("Do you want to add another task? (y/n): ");
                        yes_or_no = scn.next().charAt(0);
                        scn.nextLine();
                        if (yes_or_no == 'n') {
                            settask_loop = false;
                        }

                    }
                    break;
                case 2:
                    show_loop = true;
                    while (show_loop) {
                        System.out.println("=== Show task ===");
                        System.out.println("id      |   task    |    status     ");
                        for (int i = 0; i < rows; i++) {
                            System.out.print("\n");

                            for (int j = 0; j < cols; j++) {
                                if (tasks[i][j] != null) {
                                    System.out.print(tasks[i][j] + " | ");
                                }

                            }
                        }
                        System.out.println("\n===================");

                        System.out.print("\nDo you want to see the tasks again? (y/n): ");
                        yes_or_no = scn.next().charAt(0);
                        scn.nextLine();
                        if (yes_or_no == 'n') {
                            show_loop = false;
                        }

                    }

                    break;
                case 3:
                    mod_loop = true;
                    while (mod_loop) {
                        System.out.println("=== Editar tareas ===");
                        System.out.print("Digita el id de la tarea que quieres cambiar el status: ");
                        op_id = scn.nextInt();
                        scn.nextLine();
                        modStatus(tasks, op_id, rows);
                        System.out.print("\nQuieres modificar otra vez las tareas(y/n): ");
                        yes_or_no = scn.next().charAt(0);
                        scn.nextLine();
                        if (yes_or_no == 'n') {
                            mod_loop = false;
                        }

                    }
                    break;
                case 4:
                    options_loop = false;
                    break;

            }

        }

    }

    public static void setTarea(String tasks[][], String task, int rows, int row, int id) {

        String status = "Incomplete";

        if (row < rows && tasks[row][0] == null) {
            tasks[row][0] = id + "";
            tasks[row][1] = task;
            tasks[row][2] = status;
            System.out.println("Task added succesfully");
        } else {
            System.out.println("An error ocurred");
        }

    }

    public static void modStatus(String[][] tasks, int id, int rows) {
        String id_ = id + "";
        
        for (int i = 0; i < rows; i++) {
            if (tasks[i][0] != null) {
                if (tasks[i][0].equals(id_)) {
                    tasks[i][2] = "Complete";
                    System.out.println("Task has changed");
                    
                } else {
                    System.out.println("Task not found");
                }
            }

        }
    }
}

