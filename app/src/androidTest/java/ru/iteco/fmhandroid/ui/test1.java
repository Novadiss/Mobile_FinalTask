package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
//import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class test1 {
//
//    @Rule
//    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
//            new ActivityScenarioRule<>(AppActivity.class);
//
//    @Test
//    public void test1() {
//        ViewInteraction textInputEditText = onView(
//                allOf(childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.login_text_input_layout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());
//
//        ViewInteraction textInputEditText2 = onView(
//                allOf(childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.password_text_input_layout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());
//
//        ViewInteraction materialButton = onView(
//                allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.RelativeLayout")),
//                                        1),
//                                2),
//                        isDisplayed()));
//        materialButton.perform(click());
//
//        ViewInteraction materialButton2 = onView(
//                allOf(withId(R.id.expand_material_button),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.container_list_news_include_on_fragment_main),
//                                        0),
//                                4),
//                        isDisplayed()));
//        materialButton2.perform(click());
//
//        ViewInteraction materialButton3 = onView(
//                allOf(withId(R.id.expand_material_button),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.container_list_news_include_on_fragment_main),
//                                        0),
//                                4),
//                        isDisplayed()));
//        materialButton3.perform(click());
//
//        ViewInteraction materialTextView = onView(
//                allOf(withId(R.id.all_news_text_view), withText("All news"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_list_news_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                1),
//                        isDisplayed()));
//        materialTextView.perform(click());
//
//        ViewInteraction appCompatImageButton = onView(
//                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_news_list),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatImageButton.perform(click());
//
//        ViewInteraction materialTextView2 = onView(
//                allOf(withId(android.R.id.title), withText("Main"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView2.perform(click());
//
//        ViewInteraction recyclerView = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction recyclerView2 = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView2.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction recyclerView3 = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView3.perform(actionOnItemAtPosition(1, click()));
//
//        ViewInteraction recyclerView4 = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView4.perform(actionOnItemAtPosition(1, click()));
//
//        ViewInteraction recyclerView5 = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView5.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction appCompatImageButton2 = onView(
//                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatImageButton2.perform(click());
//
//        ViewInteraction materialTextView3 = onView(
//                allOf(withId(android.R.id.title), withText("News"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView3.perform(click());
//
//        ViewInteraction appCompatImageButton3 = onView(
//                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_news_list),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatImageButton3.perform(click());
//
//        ViewInteraction materialTextView4 = onView(
//                allOf(withId(android.R.id.title), withText("Main"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView4.perform(click());
//
//        ViewInteraction appCompatImageButton4 = onView(
//                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatImageButton4.perform(click());
//
//        ViewInteraction materialTextView5 = onView(
//                allOf(withId(android.R.id.title), withText("About"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView5.perform(click());
//
//        ViewInteraction appCompatImageButton5 = onView(
//                allOf(withId(R.id.about_back_image_button),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                1),
//                        isDisplayed()));
//        appCompatImageButton5.perform(click());
//
//        ViewInteraction appCompatImageButton6 = onView(
//                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatImageButton6.perform(click());
//
//        ViewInteraction materialTextView6 = onView(
//                allOf(withId(android.R.id.title), withText("About"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView6.perform(click());
//
//        ViewInteraction appCompatImageButton7 = onView(
//                allOf(withId(R.id.about_back_image_button),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                1),
//                        isDisplayed()));
//        appCompatImageButton7.perform(click());
//
//        ViewInteraction appCompatImageButton8 = onView(
//                allOf(withId(R.id.our_mission_image_button), withContentDescription("Our Mission"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                6),
//                        isDisplayed()));
//        appCompatImageButton8.perform(click());
//
//        ViewInteraction recyclerView6 = onView(
//                allOf(withId(R.id.our_mission_item_list_recycler_view),
//                        childAtPosition(
//                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                0)));
//        recyclerView6.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction recyclerView7 = onView(
//                allOf(withId(R.id.our_mission_item_list_recycler_view),
//                        childAtPosition(
//                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                0)));
//        recyclerView7.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction appCompatImageButton9 = onView(
//                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_our_mission),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                5),
//                        isDisplayed()));
//        appCompatImageButton9.perform(click());
//    }
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
}
