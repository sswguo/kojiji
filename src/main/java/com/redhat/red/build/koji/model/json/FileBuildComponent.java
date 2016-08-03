/*
 * Copyright (c) 2016 Red Hat, Inc. (jbrazdil@redhat.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.red.build.koji.model.json;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static com.redhat.red.build.koji.model.json.KojiJsonConstants.CHECKSUM;
import static com.redhat.red.build.koji.model.json.KojiJsonConstants.CHECKSUM_TYPE;
import static com.redhat.red.build.koji.model.json.KojiJsonConstants.CONTENT_GENERATOR;
import static com.redhat.red.build.koji.model.json.KojiJsonConstants.FILENAME;
import static com.redhat.red.build.koji.model.json.KojiJsonConstants.FILESIZE;
import static com.redhat.red.build.koji.model.json.KojiJsonConstants.HOST;
import static com.redhat.red.build.koji.model.json.util.Verifications.checkNull;

@JsonTypeName("file")
public class FileBuildComponent extends BuildComponent {

    @JsonProperty(FILENAME)
    private String filename;

    @JsonProperty(FILESIZE)
    private long filesize;

    @JsonProperty(CHECKSUM)
    private String checksum;

    @JsonProperty(CHECKSUM_TYPE)
    private String checksumType;

    public static class Builder extends BuildComponent.Builder<FileBuildComponent> {

        private final FileBuildComponent target = new FileBuildComponent();

        public Builder(String filename) {
            target.filename = filename;
        }

        public Builder(String filename, BuildRoot.Builder parent) {
            super(parent);
            target.filename = filename;
        }

        public Builder withFileSize(long size) {
            target.filesize = size;
            return this;
        }

        public Builder withChecksum(String type, String checksum) {
            target.checksumType = type;
            target.checksum = checksum;

            return this;
        }

        @Override
        public void findMissingProperties(String prefix, Set<String> missingProperties) {
            checkNull(target.filename, missingProperties, prefix, FILENAME);
            checkNull(target.filesize, missingProperties, prefix, HOST);
            checkNull(target.checksumType, missingProperties, prefix, CONTENT_GENERATOR);
            checkNull(target.checksum, missingProperties, prefix, CONTENT_GENERATOR);
        }

        @Override
        public FileBuildComponent unsafeBuild() {
            return target;
        }

        @Override
        public String getIdentifier() {
            return target.filename;
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.filename);
        hash = 53 * hash + (int) (this.filesize ^ (this.filesize >>> 32));
        hash = 53 * hash + Objects.hashCode(this.checksum);
        hash = 53 * hash + Objects.hashCode(this.checksumType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileBuildComponent other = (FileBuildComponent) obj;
        if (!Objects.equals(this.filename, other.filename)) {
            return false;
        }
        if (this.filesize != other.filesize) {
            return false;
        }
        if (!Objects.equals(this.checksum, other.checksum)) {
            return false;
        }
        if (!Objects.equals(this.checksumType, other.checksumType)) {
            return false;
        }
        return true;
    }

}
