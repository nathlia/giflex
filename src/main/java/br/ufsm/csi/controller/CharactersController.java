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
import java.util.ArrayList;

@WebServlet("/characters")
public class CharactersController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String status = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listCharacters(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Characters.jsp");
        dispatcher.forward(request, response);
    }

    private void listCharacters(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharacterDAO characterDAO = new CharacterDAO();

        try {
            ArrayList<Character> characterList = characterDAO.getCharacter();
            request.setAttribute("characterList", characterList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listCharacters(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Characters.jsp");
        dispatcher.forward(request, response);
    }
}
