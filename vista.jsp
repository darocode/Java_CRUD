<%-- 
    Document   : registrarUsuario
    Created on : 9/05/2022, 09:17:55 AM
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
    </head>
    <body>
    <center>
        <h1>Registrar Usuario</h1>
        <form action="Usuario" method="post">
            <table>
                <tr>
                    Usuario:<br>
                <input type="text" name="textLogin"><br>
                Contraseña:<br>
                <input type="password" name="textPassword"><br>
                </tr>
            </table><br>

            <button>Registrar</button>
            <input type="hidden" value="1" name="opcion">
        </form>
        <%
            if (request.getAttribute("mensajeError") != null) {%>

        ${mensajeError}

        <%} else {%>
        
        ${mensajeExito}
        
        
        <%}%>
    </center>
</body>
</html>
