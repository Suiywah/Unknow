/**
 * 一般性的工具类
 * @author feipt
 */

/**
 * 判断传入的参数是不是一个邮箱
 */
function mailValidate(mail)  {
	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	return result = re.test(userName);
}