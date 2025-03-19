package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    //problem: verilmiş olan text içerisinde her kelimenin kaç kez geçtiğini bulmak.
    //Çözümün time Complexity değeri O(n) komplesitiden daha fazla olmamalı.
    //Method dönüş tipi olarak Map<String,Integer> tipinde bir dönüşe sahip olmalı.
    // Map - key kısmı: textin içerisindeki her bir kelimeye denk gelmeli.
    // Map - Value kısmı: bu kelimenin toplamda kaç kez tekrar ettiğini tutmalı.

    public static Map<String,Integer> calculatedWord (){
        Map<String, Integer> countMap = new HashMap<>();

        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," + " due to İsmet Pasha's organization of an irregular militia into a regular army. " + " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." + " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." + " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" + " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." + " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." + " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." + " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." + " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." + " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        if (text == null || text.isEmpty()) {
            return countMap; // Boş veya null metin için boş bir harita döndür..
        }

        String[] words = text.toLowerCase().split("[^a-zA-ZçÇğĞıİöÖşŞüÜ]+"); //kelimelere ayırdık..

        for(String word: words){
            if(!word.isEmpty()){
                if(countMap.containsKey(word)) {
                    countMap.put(word, countMap.get(word) + 1);
                } else{
                    countMap.put(word,1);
                }
            }
        }

        return countMap;
    }


}
