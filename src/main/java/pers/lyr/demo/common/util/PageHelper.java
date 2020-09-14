package pers.lyr.demo.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lyr
 * @create 2020/9/14 9:50
 */
public class PageHelper {
    /**
     * 计算分页后 要显示的页码
     * @param request
     */
    public static void of(HttpServletRequest request) {
        int page = getPage(request,1);
        int size = getSize(request,5);
        Long count = (Long) request.getAttribute("count");
        int totalPage = 0;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == count % size) {
            totalPage = (int) (count/size);
        }
            // 假设总数是51，不能够被5整除的，那么就有11页
        else {
            totalPage = (int) (count/size +1);
        }

        if(0==totalPage) {
            totalPage = 1;
        }
        System.out.println(size+": : "+page
        );
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("curPage",page);
        // request.setAttribute("showPage",totalPage - page);


    }


    private static int get(HttpServletRequest request,String label,int defaultValue) {
        String ll = request.getParameter(label);
        if(ll == null || ll.isEmpty()) {
            return defaultValue;
        }
        return Integer.valueOf(ll);
    }
    private static int getPage(HttpServletRequest req,int defaultValue) {
        int page = get(req,"page",defaultValue);
        if(page <=0) {
            return 1;
        }
        return page;
    }
    private static int getSize(HttpServletRequest request,int defaultValue) {
        int size = get(request,"size",defaultValue);
        if(size <=0) {
            return defaultValue;
        }
        return size;

    }
}
