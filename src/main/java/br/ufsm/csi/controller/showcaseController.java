package br.ufsm.csi.controller;

import br.ufsm.csi.dao.CharacterArtifactDAO;
import br.ufsm.csi.dao.CharacterDAO;
import br.ufsm.csi.model.Artifact;
import br.ufsm.csi.model.Character;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showcase")
public class showcaseController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String status = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listImage(request, response);
        listCharacter(request, response);
        listArtifacts(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/showcase.jsp");
        dispatcher.forward(request, response);
    }

    private void listImage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int imageId = Integer.parseInt(request.getParameter("image"));

        try {
            request.setAttribute("image", imageId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void listArtifacts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharacterArtifactDAO characterArtifactDAO = new CharacterArtifactDAO();
        int characterId = Integer.parseInt(request.getParameter("characterId"));

        try {
            ArrayList<Artifact> characterArtifact = characterArtifactDAO.getCharacterArtifactList(characterId);
            request.setAttribute("artifactList", characterArtifact);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/showcase.jsp");
        dispatcher.forward(request, response);
    }


}
