package io.jpress.web.admin;

import io.jboot.web.controller.annotation.RequestMapping;
import io.jpress.JPressConstants;
import io.jpress.core.menu.annotation.AdminMenu;
import io.jpress.core.web.base.AdminControllerBase;
import io.jpress.model.Role;
import io.jpress.service.RoleService;
import io.jpress.service.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Michael Yang 杨福海 （fuhai999@gmail.com）
 * @version V1.0
 * @Title: 首页
 * @Package io.jpress.web.admin
 */
@RequestMapping("/admin/template")
public class _TemplateController extends AdminControllerBase {

    @Inject
    private RoleService roleService;

    @Inject
    private UserService userService;

    @AdminMenu(text = "所有模板", groupId = JPressConstants.SYSTEM_MENU_TEMPLATE, order = 0)
    public void index() {
        render("template/list.html");
    }

    public void edit() {
        render("user/edit.html");
    }

    @AdminMenu(text = "安装", groupId = JPressConstants.SYSTEM_MENU_TEMPLATE, order = 5)
    public void role() {
        List<Role> roles = roleService.findAll();
        setAttr("roles", roles);
        render("user/role.html");
    }

    public void roleEdit() {
        long id = getParaToLong("id", 0l);
        if (id > 0) {
            setAttr("role", roleService.findById(id));
        }
        render("user/role_edit.html");
    }

    public void roleSave() {
        Role role = getModel(Role.class);
        roleService.saveOrUpdate(role);
        redirect("/admin/user/role");
    }


    @AdminMenu(text = "设置", groupId = JPressConstants.SYSTEM_MENU_TEMPLATE)
    public void me() {
        render("user/me.html");
    }

    @AdminMenu(text = "编辑", groupId = JPressConstants.SYSTEM_MENU_TEMPLATE)
    public void me1() {
        render("user/me.html");
    }

}
