package day8_stack;

/**
 * 编程模拟实现一个浏览器的前进、后退功能 当你依次访问完一串页面 a-b-c 之后，点击浏览器的后退按钮，就可以查看之前浏览过的页面 b 和 a。
 * 当你后退到页面 a，点击前进按钮，就可以重新查看页面 b 和 c。但是，如果你后退到页面 b 后，点击了新的页面 d，那就无法再通过前进、后退功能查看页面
 * c 了。
 */
class Browser {

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.openPage("a");
        browser.openPage("b");
        browser.openPage("c");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.goForward();
        browser.goBack();
        browser.openPage("d");
        browser.goBack();
    }

    LinkedlistStack<String> backStack = new LinkedlistStack<>();
    LinkedlistStack<String> forwardStack = new LinkedlistStack<>();

    void openPage(String url) {
        backStack.push(url);
        System.out.println("openPage(),url:" + url + ",当前页面:" + backStack.peek());
    }

    /**
     * 向后
     */
    void goBack() {
        if (canGoBack()) {
            String url = backStack.pop();
            forwardStack.push(url);
            System.out.println("goBack(),当前页面:" + backStack.peek());
        }
    }

    boolean canGoBack() {
        return backStack.size() > 0;
    }

    /**
     * 向前
     */
    void goForward() {
        if (canGoForward()) {
            String url = forwardStack.pop();
            backStack.push(url);
            System.out.println("goForward(),当前页面:" + backStack.peek());
        }

    }

    boolean canGoForward() {
        return forwardStack.size() > 0;
    }

}