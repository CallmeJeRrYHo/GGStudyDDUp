package com.hjh.ggstudyddup.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by HJH
 * Data 2017/11/7.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
