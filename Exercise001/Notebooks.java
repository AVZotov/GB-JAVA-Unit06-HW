package ru.geekbrains.api.Seminar006.HW.Exercise001;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Notebooks {
    private final Set<Notebook> notebooks = new HashSet<>();

    public Notebooks(int notebooksQuantity) {

        generateNotebooksList(notebooksQuantity);
    }

    public void PrintAll(){
        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
    }

    public void PrintSelected(Map<String, Object> userFilter) {
        var selectedNotebooks = selectByFilter(userFilter);
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED + "\nYOUR SELECTED NOTEBOOKS LIST:\n" + ANSI_RESET);
        for (Notebook notebook : selectedNotebooks) {
            System.out.println(notebook);
        }
    }

    /**
     * @apiNote Method with simple functionality to generate notebooks with pre default parameters
     * @param notebooksQuantity amount of notebooks to be randomly generated
     */
    private void generateNotebooksList(int notebooksQuantity){
        int[] ram = new int[] {4, 8, 16, 32, 64, 128};
        int[] hdd = new int[]{128, 256, 512, 1024, 2048, 4096};
        String[] os = new String[] {"Win10Home", "Win10Professional", "Win11Home", "Win11Professional"};
        String[] color = new String[] {"Black", "Gray", "Silver", "White"};

        for (int i = 0; i < notebooksQuantity; i++) {
            Notebook notebook = new Notebook(
                    ram[getRandom(ram.length)], hdd[getRandom(hdd.length)],
                    os[getRandom(os.length)], color[getRandom(color.length)]);
            notebooks.add(notebook);
        }
    }

    /**
     *
     * @param maxValue maximal value to be generated (max value exclusive)
     * @return randomly generated Integer
     */
    private int getRandom(int maxValue){
        return ThreadLocalRandom.current().nextInt(0, maxValue);
    }

    /**
     * @param userFilter defined by user filters
     * @return Set of filtered notebooks which match user defined filters
     */
    private Set<Notebook> selectByFilter(Map<String, Object> userFilter){
        Set<Notebook> selectedNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            if(notebook.getRAM() >= (int)userFilter.get("RAM") && notebook.getHDD() >= (int)userFilter.get("HDD")){
                if (Objects.equals((String) userFilter.get("OS"), "All") || Objects.equals(notebook.getOsInstalled(), (String) userFilter.get("OS"))){
                    if (Objects.equals((String) userFilter.get("Color"), "All") || Objects.equals(notebook.getColor(), (String) userFilter.get("Color"))){
                        selectedNotebooks.add(notebook);
                    }
                }
            }
        }
        return selectedNotebooks;
    }
}
