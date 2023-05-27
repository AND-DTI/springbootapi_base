package com.and.apibase.model.dts1.dto;
import java.net.InetAddress;
import java.net.UnknownHostException;
//import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
//import com.and.apibase.model.dts1.User_Role;



public class LoginAD {

    private String user;
    private String userdns;
    private String userip;    
    //private List<User_Role> roles = new ArrayList<User_Role>();
    private List<User_RoleDTO> roles = new ArrayList<User_RoleDTO>();
    
   
   

    public LoginAD(HttpServletRequest request) /*throws UnknownHostException*/{
        
        try {

            InetAddress inetadd = InetAddress.getLocalHost();
            String host_name = inetadd.getHostName();
            String host_adress = inetadd.getHostAddress();
            
            this.user = System.getProperty("user.name");
            this.userdns = host_name;
            this.userip = host_adress;// getClientIP(request);  

        } catch (Exception e) {
            
        }

    
        //search InetSocketAddress:
        //InetSocketAddress socketAddress = (InetSocketAddress) connectedSocket.getRemoteSocketAddress();
    }


    public String getUser() {        return user;    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getUserdns() {        return userdns;    }
    public void setUserdns(String userdns) {
        this.userdns = userdns;
    }

    public String getUserip() {        return userip;    }
    public void setUserip(String userip) {
        this.userip = userip;
    }

  /*public List<User_Role> getRoles() {        return roles;    }
    public void setRoles(List<User_Role> roles) {
        this.roles = roles;
    }*/

    public List<User_RoleDTO> getRoles() {        return roles;    }
    public void setRoles(List<User_RoleDTO> roles) {
        this.roles = roles;
    }



    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARDED-FOR");
         
        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
         
        return ip;
    }




}
