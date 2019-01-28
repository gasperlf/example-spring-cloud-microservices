package lf.com.funtionsservice;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava",3));
        //System.out.println("welcometojava".substring(10,13));
    }

    public void xxx(String message, List<String> entrada){

        StringBuilder salida = new StringBuilder();
        Stream<String> stream1 = Arrays.stream(message.split(""));
        stream1.forEach(letra->{
            for(int i=1; i<entrada.size();i++){
                String cadena =  entrada.get(i);
                for (int j =0; j<cadena.length();j++){
                    if(cadena.substring(j).equals(letra)){
                        for (int k=0; k<=j+1;k++ ) {
                            salida.append(j + 1);
                        }
                    }
                }
            }
        });
//[2235533]
        int contadoresseguidos=0;
        int cont=0;
        for(int i=0; i<salida.length(); i++){
            for(int j=i+1; i<salida.length(); j++){
                if(salida.charAt(i)==salida.charAt(j)){
                    cont++;
                    break;
                }else{

                }
            }
            contadoresseguidos+=1;
            cont=0;
        }

    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        java.util.Set<String> sorted = new java.util.TreeSet<>();
        for (int j=0; j<s.length(); j++){
            for(int i=j;i<s.length(); i++){
                if(i+k<s.length()+1) {
                    //System.out.println(i +"-" + (i + k) + "->" + s.substring(i, i + k));
                    sorted.add(s.substring(i, i + k));
                }
            }
        }
        smallest = ((TreeSet<String>) sorted).first();
        largest = ((TreeSet<String>) sorted).last();

        return smallest + "\n" + largest;
    }



    /*
      0 1 2 3 4 5 6 7 8 9 10 11 12
      w e l c o m e t o j a  v  a

      wel
      elc
      lco
      com
      ome
      met
      eto
      toj
      oja
      jav

      for(int i=k-j;i<s.length()-k; i++){

                    System.out.println(s.substring(i,i+k));
                    sorted.add(s.substring(i,i+k));

            }
     */
}

