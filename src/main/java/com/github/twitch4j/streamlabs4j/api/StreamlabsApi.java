package com.github.twitch4j.streamlabs4j.api;

import com.github.twitch4j.streamlabs4j.api.domain.*;
import com.netflix.hystrix.HystrixCommand;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface StreamlabsApi {

    /**
     * Gets information about the user associated with the specified token
     *
     * @param authToken Your authentication token
     * @return the user associated with this token
     */
    @RequestLine("GET /user?" +
        "access_token={access_token}")
    HystrixCommand<StreamlabsUser> getUser(
        @Param("access_token") String authToken
    );

    /**
     * Gets donations about the user associated with the specified token <br>
     * Requires the donation.read scope
     *
     * @param authToken Your authentication token
     * @param limit     Limit the number of donations
     * @param before    Donation id of the value before your first one
     * @param after     Donation id of the value after your last one
     * @param currency  Desired currency (can be null)
     * @param verified  true = donations associated with a bank / paypal ...etc account
     *                  false = donations created by the streamer
     *                  nothing ("") = true and false
     * @return A list of donations associated with this token
     */
    @RequestLine("GET /donations?" +
        "access_token={access_token}&" +
        "limit={limit}&" +
        "before={before}&" +
        "after={after}&" +
        "currency={currency}&" +
        "verified={verified}")
    HystrixCommand<StreamlabsDonationsData> getDonations(
        @Param("access_token") String authToken,
        @Param("limit") int limit,
        @Param("before") String before,
        @Param("after") String after,
        @Param("currency") String currency,
        @Param("verified") String verified
    );

    /**
     * Gets a token allowing you to listen the user's events through sockets <br>
     * Requires the socket.token scope
     *
     * @param authToken Your authentication token
     * @return a token
     */
    @RequestLine("GET /socket/token?" +
        "access_token={access_token}")
    HystrixCommand<StreamlabsSocketTokenHolder> getSocketToken(
        @Param("access_token") String authToken
    );

    /**
     * Gets a token usable in Widgets URLs <br>
     * Requires the legacy.token scope
     *
     * @param authToken Your authentication token
     * @return a token
     */
    @RequestLine("GET /legacy/token?" +
        "access_token={access_token}")
    HystrixCommand<StreamlabsWidgetTokenHolder> getWidgetToken(
        @Param("access_token") String authToken
    );

    /**
     * Gets information about loyalty points of an user <br>
     * Requires the points.read scope AND approval from the streamlabs team
     *
     * @param authToken your authentication token
     * @param username  the user you want to search
     * @param channel   the channel you want to search
     * @return the user you searched for in the specified channel
     */
    @RequestLine("GET /points?" +
        "access_token={access_token}&" +
        "username={username}&" +
        "channel={channel}")
    HystrixCommand<StreamlabsUserPoints> getUserPoints(
        @Param("access_token") String authToken,
        @Param("username") String username,
        @Param("channel") String channel
    );

    /**
     * Gets information about loyalty points for a group of users <br>
     * Requires the points.read scope AND approval from the streamlabs team
     *
     * @param authToken your authentication token
     * @param channel   the channel you want to search
     * @param usernames users you want to search
     * @return a list of users with information about their points and minutes watched
     */
    @RequestLine("GET /points/group_get_points?" +
        "access_token={access_token}&" +
        "channel={channel}&" +
        "usernames={usernames}")
    HystrixCommand<List<StreamlabsGroupedUserPoints>> getGroupedPoints(
        @Param("access_token") String authToken,
        @Param("channel") String channel,
        @Param("usernames") List<String> usernames
    );

    /**
     * Get a information based on a partial username search <br>
     * Requires the points.read scope AND approval from the streamlabs team
     *
     * @param authToken  your authentication token
     * @param username   the partial username to search
     * @param sortBy     the sort criteria (can be username, points or time_watched)
     * @param order      order of sorting (asc or desc)
     * @param limitBy    limit results per page (between 1 and 100 included)
     * @param pageNumber the page requested (in case of multiple result pages)
     * @return a paginated list of results corresponding to the partial username
     */
    @RequestLine("GET /points/user_points?" +
        "access_token={access_token}&" +
        "username={username}&" +
        "sort={sort}&" +
        "order={order}&" +
        "limit={limit}&" +
        "page={page}")
    HystrixCommand<StreamlabsPartialUserPoints> getPartialUserPoints(
        @Param("access_token") String authToken,
        @Param("username") String username,
        @Param("sort") String sortBy,
        @Param("order") String order,
        @Param("limit") int limitBy,
        @Param("page") int pageNumber
    );

}
