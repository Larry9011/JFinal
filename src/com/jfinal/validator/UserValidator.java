package com.jfinal.validator;

import com.jfinal.core.Controller;
import com.jfinal.model.User;
import com.jfinal.validate.Validator;

/**
 * User校验器
 * @author huchengsong
 *
 */
public class UserValidator extends Validator {

	/**
	 * 用于参数校验的方法
	 */
	@Override
	protected void validate(Controller c) {

		/**
		 * 编写校验规则
		 */
		validateRequiredString("user.username", "userNameMsg", "用户名不能为空!!");
		validateRequiredString("user.realname", "realNameMsg", "真实姓名不能为空!!");
	}

	/**
	 * 错误处理的方法
	 */
	@Override
	protected void handleError(Controller c) {

		String actionKey = getActionKey();
		String view = null;
		c.keepModel(User.class);  // 保存上一次提交时候的表单记录(user.name)
		if("/user/doAddUser".equals(actionKey)){  // 这个ActionKey表示添加记录 操做

			view = "adduser.html";
		}

		if("/user/updateUser".equals(actionKey)){  // 这个ActionKey表示更新记录 操做

			view = "edituser.html";
		}
		c.renderFreeMarker(view);
	}
}
