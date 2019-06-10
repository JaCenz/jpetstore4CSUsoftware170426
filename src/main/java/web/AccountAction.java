package web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import domain.Account;
import service.AccountService;

import java.util.Map;

public class AccountAction implements Action {
    private Account account;
    private boolean authenticated;
    private String securityCode;
    AccountService accountService = new AccountService();

    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String execute() throws Exception {
        return "abc";
    }
   /*进入登录页面*/
    public String signOnForm() throws Exception{
        return "login";
    }

    /*登录*/
    public String signOn() throws Exception{
        account = accountService.getAccount(account.getUsername(),account.getPassword());

        String serverCode = (String)session.get("SESSION_SECURITY_CODE");

        if(account == null){
            String error = (String)session.get("error2");
            if(error != null)
                session.remove("error2");

            session.put("error1","Invalid username or password.  SignOn failed.");
            return ERROR;
        }
        else if(!serverCode.equals(securityCode)){
            String error = (String)session.get("error1");
            if(error != null)
                session.remove("error1");

            session.put("error2","Invalid identifying code. SignOn failed.");
            authenticated = false;
            session.put("authenticated",authenticated);
            return ERROR;
        }
        else
        {
            authenticated = true;
            session.put("account",account);
            session.put("authenticated",authenticated);
            return SUCCESS;
        }
    }
    /*进入注册页面*/
    public String registerForm() throws Exception{
        return SUCCESS;
    }
    /*注册*/
    public String register() throws Exception{
        if(!(account.getUsername().equals("") || account.getPassword().equals(""))){
            if(account.getPassword().equals(account.getRepeatedPassword())){
                Account temp = accountService.getAccountByUsername(account.getUsername());
                //若用户名可以使用则创建
                if(temp == null){
                    accountService.insertAccount(account);
                    //这里不知道需不需要清除account
                    /*Account t = null;
                    session.put("account",t);*/
                    authenticated = true;
                    session.put("authenticated",authenticated);
                    session.put("account",account);
                    return SUCCESS;
                }
            }
        }
        authenticated = false;
        Account t = null;
        session.put("account",t);
        return ERROR;
    }
    /*进入编辑页面*/
    public String editAccountForm(){
        return SUCCESS;
    }
    /*编辑账号*/
    public String editAccount(){
        if(account.getPassword().equals(account.getRepeatedPassword())){
            session.put("account",account);
            accountService.updateAccount(account);
            return SUCCESS;
        }
        return ERROR;
    }
    /*登出*/
    public String signOut(){
        Account t = null;
        session.put("account",t);
        return SUCCESS;
    }
}
