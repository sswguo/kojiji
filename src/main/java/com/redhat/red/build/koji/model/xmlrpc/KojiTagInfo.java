/**
 * Copyright (C) 2015 Red Hat, Inc. (jcasey@redhat.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.red.build.koji.model.xmlrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.red.build.koji.model.converter.StringListConverter;
import org.commonjava.rwx.anno.Converter;
import org.commonjava.rwx.anno.DataKey;
import org.commonjava.rwx.anno.StructPart;

import java.util.List;

/**
 * Created by jdcasey on 1/6/16.
 */
@StructPart
public class KojiTagInfo
{
    @DataKey( "id" )
    private int id;

    @DataKey( "name" )
    private String name;

    @DataKey( "perm" )
    @JsonProperty( "perm" )
    private String permission;

    @DataKey( "perm_id" )
    @JsonProperty( "perm_id" )
    private Integer permissionId;

    @DataKey( "arches" )
    @Converter( StringListConverter.class )
    private List<String> arches;

    @DataKey( "locked" )
    private boolean locked;

    @DataKey( "maven_support" )
    @JsonProperty( "maven_support" )
    private boolean mavenSupport = true;

    @DataKey( "maven_include_all" )
    @JsonProperty( "maven_include_all" )
    private boolean mavenIncludeAll = true;

    public KojiTagInfo(){}

    public KojiTagInfo( int id, String name, String permission, Integer permissionId, List<String> arches, boolean locked,
                        boolean mavenSupport, boolean mavenIncludeAll )
    {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.permissionId = permissionId;
        this.arches = arches;
        this.locked = locked;
        this.mavenSupport = mavenSupport;
        this.mavenIncludeAll = mavenIncludeAll;
    }

    public KojiTagInfo(String name)
    {
        this.name = name;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public boolean getLocked()
    {
        return locked;
    }

    public void setLocked( boolean locked )
    {
        this.locked = locked;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPermission()
    {
        return permission;
    }

    public Integer getPermissionId()
    {
        return permissionId;
    }

    public List<String> getArches()
    {
        return arches;
    }

    public boolean isLocked()
    {
        return locked;
    }

    public boolean isMavenSupport()
    {
        return mavenSupport;
    }

    public boolean getMavenSupport()
    {
        return mavenSupport;
    }

    public boolean isMavenIncludeAll()
    {
        return mavenIncludeAll;
    }

    public boolean getMavenIncludeAll()
    {
        return mavenIncludeAll;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setPermission( String permission )
    {
        this.permission = permission;
    }

    public void setPermissionId( Integer permissionId )
    {
        this.permissionId = permissionId;
    }

    public void setArches( List<String> arches )
    {
        this.arches = arches;
    }

    public void setMavenSupport( boolean mavenSupport )
    {
        this.mavenSupport = mavenSupport;
    }

    public void setMavenIncludeAll( boolean mavenIncludeAll )
    {
        this.mavenIncludeAll = mavenIncludeAll;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( !( o instanceof KojiTagInfo ) )
        {
            return false;
        }

        KojiTagInfo that = (KojiTagInfo) o;

        return getId() == that.getId();

    }

    @Override
    public int hashCode()
    {
        return Integer.valueOf( getId() ).hashCode();
    }
}
