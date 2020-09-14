package com.doublefs.common.javatemplate.example;

import io.sentry.Sentry;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

/**
 * @author liuqingliang
 * http://sentry.intra.doublefs.com/dfs/xcrawler/getting-started/java/
 */
public class SentryExample {

    public static void main(String[] args) {
        // usage detail: http://sentry.intra.doublefs.com/dfs/xcrawler/getting-started/java/
        System.out.println("Here is Sentry example");
        // just need to init once. This's XCrawler project's dsn code.
        Sentry.init("http://92b3dd446317422596df80d39e99491e@sentry.intra.doublefs.com/5");

        SentryExample myClass = new SentryExample();
        myClass.logWithStaticApi();
    }

    /**
     * An example method that throws an exception.
     */
    void unsafeMethod() {
        throw new UnsupportedOperationException("You shouldn't call this!");
    }

    void logWithStaticApi() {
        // Note that all fields set on the context are optional. Context data is copied onto
        // all future events in the current context (until the context is cleared).

        // Record a breadcrumb in the current context. By default the last 100 breadcrumbs are kept.
        Sentry.getContext().recordBreadcrumb(
                new BreadcrumbBuilder().setMessage("User made an action").build()
        );

        // Set the user in the current context.
        Sentry.getContext().setUser(
                new UserBuilder().setEmail("sentry@doublefs.com").build()
        );

        // Add extra data to future events in this context.
        Sentry.getContext().addExtra("extra", "thing");

        // Add an additional tag to future events in this context.
        Sentry.getContext().addTag("tagName", "tagValue");

        /*
         This sends a simple event to Sentry using the statically stored instance
         that was created in the ``main`` method.
         */
        Sentry.capture("This is a test");

        try {
            unsafeMethod();
        } catch (Exception e) {
            // This sends an exception event to Sentry using the statically stored instance
            // that was created in the ``main`` method.
            Sentry.capture(e);
        }
    }
}
