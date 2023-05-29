package com.example.brand.config.paging;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import com.example.brand.dto.ResponseTableDto;

public class PagingResolve implements HandlerMethodArgumentResolver {

    // chỉ định hỗ trợ loại oaram nào
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(PagingParam.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        PagingParam pagingParam = parameter.getParameterAnnotation(PagingParam.class);
        String path = pagingParam.path();
        String pageStr = webRequest.getParameter("page");
        Integer page = StringUtils.isEmpty(pageStr) ? 1 : Integer.valueOf(pageStr);
        String perPageStr = webRequest.getParameter("perpage");
        Integer perpage = StringUtils.isEmpty(perPageStr) ? 5 : Integer.valueOf(perPageStr);
        String key = webRequest.getParameter("key");
        key = StringUtils.isEmpty(key) ? "" : key;
        return new ResponseTableDto(path, page, perpage, key, mavContainer);
    }
}
