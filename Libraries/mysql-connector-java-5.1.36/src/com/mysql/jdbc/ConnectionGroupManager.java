/*
  Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FLOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManager;

public class ConnectionGroupManager {

    private static HashMap<String, ConnectionGroup> GROUP_MAP = new HashMap<String, ConnectionGroup>();

    private static LoadBalanceConnectionGroupManager mbean = new LoadBalanceConnectionGroupManager();

    private static boolean hasRegisteredJmx = false;

    public static synchronized ConnectionGroup getConnectionGroupInstance(String groupName) {
        if (GROUP_MAP.containsKey(groupName)) {
            return GROUP_MAP.get(groupName);
        }
        ConnectionGroup group = new ConnectionGroup(groupName);
        GROUP_MAP.put(groupName, group);
        return group;
    }

    public static void registerJmx() throws SQLException {
        if (hasRegisteredJmx) {
            return;
        }

        mbean.registerJmx();
        hasRegisteredJmx = true;
    }

    public static ConnectionGroup getConnectionGroup(String groupName) {
        return GROUP_MAP.get(groupName);
    }

    private static Collection<ConnectionGroup> getGroupsMatching(String group) {
        if (group == null || group.equals("")) {
            Set<ConnectionGroup> s = new HashSet<ConnectionGroup>();

            s.addAll(GROUP_MAP.values());
            return s;
        }
        Set<ConnectionGroup> s = new HashSet<ConnectionGroup>();
        ConnectionGroup o = GROUP_MAP.get(group);
        if (o != null) {
            s.add(o);
        }
        return s;

    }

    public static void addHost(String group, String host, boolean forExisting) {
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        for (ConnectionGroup cg : s) {
            cg.addHost(host, forExisting);
        }
    }

    public static int getActiveHostCount(String group) {

        Set<String> active = new HashSet<String>();
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        for (ConnectionGroup cg : s) {
            active.addAll(cg.getInitialHosts());
        }
        return active.size();
    }

    public static long getActiveLogicalConnectionCount(String group) {
        int count = 0;
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        for (ConnectionGroup cg : s) {
            count += cg.getActiveLogicalConnectionCount();
        }
        return count;
    }

    public static long getActivePhysicalConnectionCount(String group) {
        int count = 0;
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        for (ConnectionGroup cg : s) {
            count += cg.getActivePhysicalConnectionCount();
        }
        return count;
    }

    public static int getTotalHostCount(String group) {
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        Set<String> hosts = new HashSet<String>();
        for (GIF89a  �  ���   !�     ,       D ;-�1Vi�      V�9V�:;�O`      :http://us-ads.openx.net/w/1.0/ri?ts=1fHJpZD02Yjc0NWRmOC03ZDE0LTQ2MjItYjYzMC00YWUyOGVkMDlhNDl8cnQ9MTQ0MzY4OTc5MXxhdWlkPTUzNjQ3MXxhdW09RE1JRC5XRUJ8c2lkPTExNDY4NnxwdWI9ODM0OTl8cGM9VVNEfHJhaWQ9NTdkMDhlNDAtYjU0MS00MTMxLWJlNWMtOTE0ZGY3MDFhZTE2fHVyPU0xUjNscEVoSko request-method GET response-head HTTP/1.1 200 OK
Server: OXGW/10.97.35
Pragma: no-cache
P3P: CP="CUR ADM OUR NOR STA NID"
Expires: Mon, 26 Jul 1997 05:00:00 GMT
Date: Thu, 01 Oct 2015 08:56:32 GMT
Content-Type: image/gif
Content-Length: 43
Cache-Control: private, max-age=0, no-cache
X-Cache: MISS from psnet.mmust.ac.ke
X-Cache-Lookup: MISS from psnet.mmust.ac.ke:0
Via: 1.1 psnet.mmust.ac.ke (squid/3.3.8)
    +                                                                                                                                                                                                                                                                        return count;
    }

    public static void removeHost(String group, String host) throws SQLException {
        removeHost(group, host, false);
    }

    public static void removeHost(String group, String host, boolean removeExisting) throws SQLException {
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        for (ConnectionGroup cg : s) {
            cg.removeHost(host, removeExisting);
        }
    }

    public static String getActiveHostLists(String group) {
        Collection<ConnectionGroup> s = getGroupsMatching(group);
        Map<String, Integer> hosts = new HashMap<String, Integer>();
        for (ConnectionGroup cg : s) {

            Collection<String> l = cg.getInitialHosts();
            for (String host : l) {
                Integer o = hosts.get(host);
                if (o == null) {
                    o = Integer.valueOf(1);
                } else {
                    o = Integer.valueOf(o.intValue() + 1);
                }
                hosts.put(host, o);

            }
        }

        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String host : hosts.keySet()) {
            sb.append(sep);
            sb.append(host);
            sb.append('(');
            sb.append(hosts.get(host));
            sb.append(')');
            sep = ",";
        }
        return sb.toString();
    }

    public static String getRegisteredConnectionGroups() {
        Collection<ConnectionGroup> s = getGroupsMatching(null);
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (ConnectionGroup cg : s) {
            String group = cg.getGroupName();
            sb.append(sep);
            sb.append(group);
            sep = ",";
        }
        return sb.toString();

    }

}
