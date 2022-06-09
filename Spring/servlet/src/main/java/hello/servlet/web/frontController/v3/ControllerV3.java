package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.v2.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
