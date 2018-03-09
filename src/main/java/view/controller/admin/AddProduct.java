/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.admin;

import controller.DAODelegate.DAOService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Eman-PC
 */
public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOService daoService = new DAOService();
        Product product = new Product();
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();

                    System.out.println(name + ":" + value);
                    switch (name) {
                        case "productName":
                            product.setName(value);
                            break;
                        case "productPrice":
                            float val = Float.parseFloat(item.getString());
                            product.setPrice(val);
                            break;
                        case "productCategory":
                            product.setCategory(value);
                            break;
                        case "productAmount":
                            int val2 = Integer.parseInt(item.getString());
                            product.setAmount(val2);
                            break;
                        case "productDescription":
                            product.setDescription(value);
                            break;
                    }
                } else {
                    ServletContext context = request.getServletContext();
                    String realpath = context.getRealPath("/MainPages/images");
                    System.out.println(realpath + "\\" + item.getName());
                    item.write(new File(realpath + "\\" + item.getName()));
                    product.setImgURL(realpath + "\\" + item.getName());
                }
            }

//		String filePath = request.getRealPath("/");
            // Image image = new ImageIcon(this.getClass().getResource("/images/")).getImage();
        } catch (FileUploadException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        daoService.addProduct(product);
    }
}