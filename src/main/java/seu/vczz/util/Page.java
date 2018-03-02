package seu.vczz.util;

import java.lang.annotation.Target;

/**
 * CREATE by vczz on 2018/3/2
 * 供分页使用的工具类
 */
public class Page {

    private int start;//开始的页数
    private int count;//每页显示个数
    private int total;//总个数\
    private String param;//参数

    private static final int DEFAULECOUNT = 5;//默认每页显示5个

    /**无参构造函数**/
    public Page(){
        this.count = DEFAULECOUNT;
    }
    /**带参构造函数**/
    public Page(int start, int count){
        this();
        this.start = start;
        this.count = count;
    }
    /**是否有前一页**/
    public boolean isHasPrevious(){
        if (start == 0)
            return false;
        return true;
    }
    /**是够有下一页**/
    public boolean isHasNext(){
        if (start==getLast())
            return false;
        return true;
    }
    /**计算总的页数**/
    public int getTotalPage(){
        int totalPage;
        //能够整除，总页数
        if (0 == total%count)
            totalPage = total/count;
        else
            totalPage = total/count + 1;
        //刚好只有一页
        if (0 == totalPage)
            totalPage = 1;
        return totalPage;
    }
    /**最后一页的开始项**/
    public int getLast(){
        int last;
        //计算最后一页的开始项
        if (0 == total%count)
            last = total - count;
        else
            last = total - total%count;
        //不存在的
        last = last<0?0:last;
        return last;
    }

    @Override
    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPrevious()=" + isHasPrevious() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public String getParam() {
        return param;
    }

    public void setStart(int start) {

        this.start = start;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
