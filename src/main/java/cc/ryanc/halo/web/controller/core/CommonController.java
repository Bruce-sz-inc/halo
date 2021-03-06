package cc.ryanc.halo.web.controller.core;

import cc.ryanc.halo.model.dto.HaloConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : RYAN0UP
 * @date : 2017/12/26
 * @version : 1.0
 * description:
 */
@Slf4j
@Controller
public class CommonController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    /**
     * 渲染404，500
     *
     * @param request request
     * @return string
     */
    @GetMapping(value = ERROR_PATH)
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 404) {
            return "redirect:/404";
        } else {
            return "redirect:/500";
        }
    }

    /**
     * 渲染404页面
     *
     * @param model model
     * @return string
     */
    @GetMapping(value = "/404")
    public String fourZeroFour(Model model) {
        //设置选项
        model.addAttribute("options", HaloConst.OPTIONS);
        return "common/404";
    }

    /**
     * 渲染500页面
     *
     * @param model model
     * @return string
     */
    @GetMapping(value = "/500")
    public String fiveZeroZero(Model model) {
        //设置选项
        model.addAttribute("options", HaloConst.OPTIONS);
        return "common/500";
    }

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
