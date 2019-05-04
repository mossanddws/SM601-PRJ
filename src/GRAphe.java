import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class GRAphe {
    int nb_sommet;
    int nb_arc;
    int arcs[][];
    int adjacence[][];
    int start;
    int end;
    public GRAphe()
    {
        File file = new File("Z:/TG/TG_Projet/test1.txt");
        FileInputStream fis = null;
        try {
                fis = new FileInputStream(file);
                System.out.println("Total file size to read (in bytes) : "
                                + fis.available());

                int content;
                String mot = "";
                        
                char tContent ;
                
                // Lecture du nombre de sommet
                content = fis.read();
                tContent = (char) content;
                while (tContent != ' ' && tContent != '\n'){
                    mot = mot + tContent;
                    content = fis.read();
                    tContent = (char) content;
                }
                mot = mot.substring(0, mot.length() - 1);
                System.out.println(mot);
                nb_sommet = Integer.valueOf(mot);
                mot = "";
                
               // Lecture du nombre d'arc
                content = fis.read();
                tContent = (char) content;
                while (tContent != ' ' && tContent != '\n') {
                    mot = mot + tContent;
                    content = fis.read();
                    tContent = (char) content;
                }
               mot = mot.substring(0, mot.length() - 1);
               System.out.println(mot);
               nb_arc = Integer.parseInt(mot);
               mot = "";
               
               // Lecture des arcs
               int compteurLigne = 0;
               int compteurColonne = 0;
               arcs = new int[nb_arc][3];

               //Import du reste du fichier dans un String
               mot = "";
                while((content = fis.read()) != -1)
                {
                   
                    tContent = (char) content;
                    if(tContent == '\n')
                    {
                        content = fis.read();
                        tContent = (char) content;
                    }


                mot = mot + tContent;
            }
             // Gestion du String pour stocker les données qu'il contient.

             int indexNextSpace = -1;
             int compteur = 0;
             while(mot != "")
             {

                  System.out.println("mot = " + mot);
                  if(mot.indexOf('\r') !=-1)
                  {
                        indexNextSpace = Math.min(mot.indexOf(" "), mot.indexOf('\r'));
                  }
                  else if (mot.indexOf(' ') !=-1)
                  {
                      indexNextSpace = mot.indexOf(" ");
                  }

                  if(mot.indexOf(' ') ==-1 && mot.indexOf('\r') ==-1)
                  {
                       arcs[compteur/3][compteur%3] = Integer.parseInt(mot);
                       mot = "";
                  }
                  else
                  {
                      System.out.println("indexNextSpace = " + indexNextSpace );
                      arcs[compteur/3][compteur%3] = Integer.parseInt(mot.substring(0, indexNextSpace));
                      System.out.println("arcs[0][0] = " + arcs[compteur/3][compteur%3]);

                      if(mot.length() != 1) mot = mot.substring(indexNextSpace + 1, mot.length());
                      compteur++;
                  }

             }
               
               
              for(int i = 0; i < nb_arc; i++) // affichage arcs
            {
                for(int j = 0; j < 3; j++)
                {
                    System.out.printf("arcs[%d][%d] = %d\n", i, j, arcs[i][j]);
                }
            }

              
            adjacence = new int[nb_sommet][nb_sommet]; // Matrice d'adjacence
            
            for(int i = 0; i < nb_sommet; i++)   // initialisation de toutes les cases à 0
            {
                for(int j = 0; j < nb_sommet; j++)
                {
                    adjacence[i][j] = 0;
                }
            }
            
            for(int i = 0; i < nb_arc; i++) // recherche des arcs
            {
                adjacence[arcs [i][0]][arcs [i][1]]= 1;
            }
            
            
            for(int i = 0; i < nb_sommet; i++) // affichage adjacence
            {
                for(int j = 0; j < nb_sommet; j++)
                {
                    System.out.printf("adjacence[%d][%d] = %d\n", i, j, adjacence[i][j]);
                }
            }
              
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (fis != null)
                                fis.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
        
        this.rechercheStart();
        this.rechercheEnd();
	}
    
    public boolean rechercheStart()
    {
        int compteur;
        int sommet_start = -1;
        for(int j = 0; j < nb_sommet; j++)
        {
            compteur = 0;
            for(int i = 0; i < nb_sommet; i++)
            {
                compteur = compteur + adjacence[i][j];
            }
            if(compteur == 0)
            {
                if(sommet_start == -1)
                {
                    sommet_start = j;
                }
                else
                {
                    System.out.printf("Plusieurs sommets n'ont pas de prédecesseurs\n");
                    return false;
                }
            }
        }
        if(sommet_start == -1)
        {
            System.out.printf("Aucun sommet n'a de prédecesseurs\n");
            return false;
        }
        else
        {
            start = sommet_start;
            System.out.printf("Le sommet start est : %d\n", start);
            return true;
        }
    }
    
    
    public boolean rechercheEnd()
    {
        int compteur;
        int sommet_end = -1;
        for(int i = 0; i < nb_sommet; i++)
        {
            compteur = 0;
            for(int j = 0; j < nb_sommet; j++)
            {
                compteur = compteur + adjacence[i][j];
            }
            if(compteur == 0)
            {
                if(sommet_end == -1)
                {
                    sommet_end = i;
                }
                else
                {
                    System.out.printf("Plusieurs sommets n'ont pas de successeurs\n");
                    return false;
                }
            }
        }
        if(sommet_end == -1)
        {
            System.out.printf("Aucun sommet n'a de successeurs\n");
            return false;
        }
        else
        {
            end = sommet_end;
            System.out.printf("Le sommet end est : %d\n", end);
            return true;
        }
    }
    
    public void printAdjacence()
    {
        
        System.out.println("Matrice d'adjacence, parfum pour homme, Paco le Rabane:");
        
        System.out.print("    ");
        for(int i = 0; i < nb_sommet; i++)
        {
             System.out.print(i + "  ");
        }
        System.out.println("");
        System.out.print("   ");
        for(int i = 0; i < nb_sommet; i++)
        {
             System.out.print(" - ");
        }
        System.out.println("");
        for(int i = 0; i < nb_sommet; i++)  
            {
                System.out.print(i + " | ");
                for(int j = 0; j < nb_sommet; j++)
                {
                    System.out.printf("%d  ", adjacence[i][j]);
                }
                System.out.print("|");
                System.out.println();
            }
                System.out.print("   ");
        for(int i = 0; i < nb_sommet; i++)
        {
             System.out.print(" - ");
        }
                System.out.println("");
    }
}
    
   
    

