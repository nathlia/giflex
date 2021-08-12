package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ArtifactTypeDAO;
import br.ufsm.csi.model.ArtifactType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-artifact")
public class ArtifactSetTypeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtifactTypeDAO ArtTypeDao = new ArtifactTypeDAO();

        try {
            List<ArtifactType> artifactTypeList = ArtTypeDao.getArtifactType();
            request.setAttribute("artifactTypeList", artifactTypeList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("addArtifact.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
