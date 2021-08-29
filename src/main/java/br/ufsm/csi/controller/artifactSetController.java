package br.ufsm.csi.controller;


import br.ufsm.csi.dao.CharacterArtifactDAO;
import br.ufsm.csi.dao.CharacterDAO;
import br.ufsm.csi.model.Artifact;
import br.ufsm.csi.model.Character;
import br.ufsm.csi.model.CharacterArtifact;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ArtifactSet")
public class artifactSetController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String status = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listCharacter(request, response);
        listArtifacts(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/artifactSet.jsp");
        dispatcher.forward(request, response);
    }

    private void listArtifacts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int characterId = Integer.parseInt(request.getParameter("characterId"));

        //CharacterArtifact characterArtifactFound;

        CharacterArtifactDAO characterArtifactDAO = new CharacterArtifactDAO();

        ArrayList<Artifact> characterArtifact = characterArtifactDAO.getCharacterArtifactList(characterId);

        //int artifactFoundTypeId = characterArtifactFound.getArtifact().getArtifactSetTypeId();

        try {
            //if (artifactFoundTypeId == 1) {
                //listArtifactSetType(request, response, characterArtifactFound);
                //listMainStat();
                //listMainStatValue();
                //listSubstat();
                //listArtifactSubstatValue();
            //}
            request.setAttribute("artifactList", characterArtifact);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

//    private void listArtifactSetType(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        ArtifactSetTypeDAO artifactSetTypeDAO = new ArtifactSetTypeDAO();
//
//        int artifactSetTypeId;
//        //artifactSetTypeId = characterArtifact.getArtifact().getArtifactSetType().getArtifactSetTypeId();
//
//        try {
//            ArtifactSetType artifactSetType = artifactSetTypeDAO.getArtifactSetTypebyId(artifactSetTypeId);
//            request.setAttribute("artifactSetType", artifactSetType);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ServletException(e);
//        }
//    }

    private void listCharacter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharacterDAO characterDao = new CharacterDAO();

        int characterId = Integer.parseInt(request.getParameter("characterId"));

        try {
            Character character = characterDao.getCharacterById(characterId);
            request.setAttribute("character", character);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int characterId = Integer.parseInt(request.getParameter("characterId"));
        System.out.printf("Character ID: %d", characterId);

        listCharacter(request, response);
        listArtifacts(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/artifactSet.jsp");
        dispatcher.forward(request, response);
    }

    public CharacterArtifact findArtifact(int id, ArrayList<CharacterArtifact> character) {
        //ArrayList<ArtifactsEquipped> artifactsEquipped = new ArrayList<>();

        for (CharacterArtifact characterArtifact : character) {
            if (characterArtifact.getCharacter().getCharacterId() == id) {
                return characterArtifact;
            }
        }
        return null;
    }
}
