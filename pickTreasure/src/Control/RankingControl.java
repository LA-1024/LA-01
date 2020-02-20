package Control;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class RankingControl {

   public RankingData[] rd = new RankingData[100];
   public RankingData [] rg = new RankingData[100];
   public HashMap<String,Integer> hp = new HashMap<>();


    public void handlingText() throws IOException
    {
        hp.clear();
        FileInputStream fis = new FileInputStream("src/file/rankingList.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String s,key;
        int i = 0,score;
        while((s=br.readLine()) != null)
        {
            int index = s.indexOf(" ");
            key = s.substring(0, index);
            score = Integer.parseInt(s.substring(index + 1));
            if ((hp.containsKey(key) && score > hp.get(key)) || !hp.containsKey(key))
            {
                hp.put(key,score);
                rd[i].setName(key);
                rd[i++].setScore(score);
            }
        }
        br.close();
        fis.close();


        int [] list = new int[100];
        for(int j = 0;j < list.length;j++)
        {
            list[j] = rd[j].getScore();
        }
        Arrays.sort(list);

        for(int k = 0;k < list.length;k++)
        {
            for(int n = 0;n < rd.length;n++)
            {
                if (list[k] == rd[n].getScore())
                {
                    rg[k].setScore(rd[n].getScore());
                    rg[k].setName(rd[n].getName());
                    rd[n].setScore(0);
                    break;
                }
            }
        }
    }

    public void reSetList() throws IOException
    {
        FileWriter fileWriter =new FileWriter(new File("src/file/rankingList.txt"));
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
        try
        {   //字节流
            //输出流,true表示文件内容可追加(续写),不会覆盖
            FileOutputStream fop = new FileOutputStream("src/file/rankingList.txt",true);
            //BufferedOutputStream bos = new BufferedOutputStream(fop);
            PrintWriter pw = new PrintWriter(fop);
            for(int i = rg.length-1;i >=rg.length-10 ;i--)
            {
                pw.println(rg[i].getName() + " " + rg[i].getScore());
            }
            pw.close();
            fop.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
