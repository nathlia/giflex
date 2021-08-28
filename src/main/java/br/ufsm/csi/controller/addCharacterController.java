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

@WebServlet("/addCharacter")
public class addCharacterController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    String status = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listCharacters(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addCharacter.jsp");
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

//        String option = request.getParameter("select-character");
//        String selected = "";
//
//        if (option.equals("Select")) {
//            int selectedCharacterId = Integer.parseInt(request.getParameter("characterList"));
//
//            System.out.printf("Selected ID: %d", selectedCharacterId);
//
//        }

       String levelSting = request.getParameter("level");

       double level = (levelSting == null || levelSting.isEmpty())
               ? 0
               : Double.parseDouble(levelSting);

       System.out.printf("Level: %.2f", level);

        listCharacters(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addCharacter.jsp");
        dispatcher.forward(request, response);
    }
}
