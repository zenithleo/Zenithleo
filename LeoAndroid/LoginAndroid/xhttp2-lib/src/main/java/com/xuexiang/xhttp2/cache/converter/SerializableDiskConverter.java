/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xhttp2.cache.converter;

import com.xuexiang.xhttp2.logs.HttpLog;
import com.xuexiang.xhttp2.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

public class SerializableDiskConverter implements IDiskConverter {

    @Override
    public <T> T load(InputStream source, Type type) {
        //序列化的缓存不需要用到clazz
        T value = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(source);
            value = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            HttpLog.e(e);
        } finally {
            Utils.closeIO(ois);
        }
        return value;
    }

    @Override
    public boolean writer(OutputStream sink, Object data) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(sink);
            oos.writeObject(data);
            oos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            HttpLog.e(e);
        } finally {
            Utils.closeIO(oos);
        }
        return false;
    }

}
