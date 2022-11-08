package com.learnjavaee.metier.facade;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class FichierFacade {
    private static final int TAILLE_TAMPON = 10240;
   
	

    /**
     * Cette méthode permet de recupérer l'objet qui encapsule le fichier depuis la JSP et écrit le fichier dans le répertoire indiquer
     * @param part
     * @param nomFichier
     * @param chemin
     * @throws IOException
     */
    public void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        try  (BufferedInputStream entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
        		BufferedOutputStream sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON)){
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } catch (IOException ignore) {
        	ignore.printStackTrace();
        }
    }
    
    /**
     * Cette méthode permet de recupérer le nom du fichier 
     * @param part
     * @return
     */
    public String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   

}
