package web;

import java.util.Locale;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ChangelanAction extends ActionSupport{

    public String execute() throws Exception {
        //获得本地默认的语言环境
        Locale locale=Locale.getDefault();
        //存入到一个session变量中。"WW-TRANS-I18N-LOCALE"为固定写法
        ActionContext.getContext().getSession().put("WW-TRANS-I18N-LOCALE", locale);
        return SUCCESS;
    }

}
