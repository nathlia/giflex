package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ArtifactTypeDAO;
import br.ufsm.csi.dao.CharacterDAO;
import br.ufsm.csi.model.ArtifactType;
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
public class ArtifactSetTypeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        listArtifactType(request, response);
        listCharacters(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addArtifact.jsp");
        dispatcher.forward(request, response);
    }

    private void listCharacters(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharacterDAO characterDao = new CharacterDAO();

        try {
            ArrayList<Character> characterList = characterDao.getCharacter();
            request.setAttribute("character", characterList.get(1));

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listCharacters(request, response);
        listArtifactType(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addArtifact.jsp");
        dispatcher.forward(request, response);
    }
}
