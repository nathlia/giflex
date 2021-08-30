package br.ufsm.csi.controller;

import br.ufsm.csi.dao.*;
import br.ufsm.csi.model.*;
import br.ufsm.csi.model.Character;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addArtifact")
public class addArtifactController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String status = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        listArtifactType(request, response);
        listCharacter(request, response);
        listArtifactSetType(request, response);
        listMainStat(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addArtifact.jsp");
        dispatcher.forward(request, response);
    }

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

    private void listArtifactType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtifactTypeDAO ArtTypeDao = new ArtifactTypeDAO();

        try {
            ArrayList<ArtifactType> artifactTypeList = ArtTypeDao.getArtifactType();
            request.setAttribute("artifactTypeList", artifactTypeList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void listArtifactSetType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtifactSetTypeDAO artifactSetTypeDao = new ArtifactSetTypeDAO();

        try {
            ArrayList<ArtifactSetType> artifactSetTypeList = artifactSetTypeDao.getArtifactSetType();
            request.setAttribute("artifactSetTypeList", artifactSetTypeList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void listMainStat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubstatDAO substatDao = new SubstatDAO();

        try {
            ArrayList<Substat> substatList = substatDao.getSubstat();
            request.setAttribute("artifactMainStat", substatList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int characterId = Integer.parseInt(request.getParameter("characterId"));
        int artifactTypeId = Integer.parseInt(request.getParameter("artifactType"));
        int artifactSetId = Integer.parseInt(request.getParameter("artifactSet"));
        int mainSetId = Integer.parseInt(request.getParameter("mainStat"));
        String mainStatValueString = request.getParameter("mainStatValue");

        double mainStatValue = (mainStatValueString == null || mainStatValueString.isEmpty())
                ? 0
                : Double.parseDouble(mainStatValueString);

        System.out.printf("Character ID: %d\n Type: %d \nSet: %d \nMainStatId: %d \nvalue: %.2f\n", characterId, artifactTypeId, artifactSetId, mainSetId, mainStatValue);

        ArtifactDAO artifactDAO = new ArtifactDAO();

        Artifact artifact = new Artifact(artifactTypeId, artifactSetId, mainSetId, mainStatValue);
        status = artifactDAO.insert(artifact);

        int artifactId = artifact.getArtifactId();

        System.out.printf(" Artifact ID: %d\n", artifactId);

        CharacterArtifactDAO characterArtifactDAO = new CharacterArtifactDAO();

        CharacterArtifact characterArtifact = new CharacterArtifact(characterId, artifactId);
        status = characterArtifactDAO.insert(characterArtifact);

        response.sendRedirect("/app_genshin_flex/ArtifactSet?characterId=" + characterId);
    }
}
