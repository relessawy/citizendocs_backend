package com.masteringopenshift.citizendocs.backend;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/documents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentResource {

    @GET
    @Path("/{username}")
    public List<Document> getDocuments(@PathParam("username") String username) {
        return Document.find("username", username).list();
    }

    @POST
    public void addDocument(Document document) {
        document.persist();
    }

    @PUT
    @Path("/{id}")
    public void updateDocument(@PathParam("id") Long id, Document document) {
        Document entity = Document.findById(id);
        if (entity != null) {
            entity.documentType = document.documentType;
            entity.status = document.status;
            entity.persist();
        }
    }
}
