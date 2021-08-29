package br.ufsm.csi.controller;


import br.ufsm.csi.dao.CharacterDAO;
import br.ufsm.csi.model.Character;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArtifactSet")
public class artifactSetController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String status = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listCharacter(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/artifactSet.jsp");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listCharacter(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/artifactSet.jsp");
        dispatcher.forward(request, response);
    }
}
