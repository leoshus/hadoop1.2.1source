/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.ipc;

import java.io.IOException;

/**
 * 所有使用Hadoop RPC的协议的父接口
 * HDFS相关 
		ClientDatanodeProtocol ：一个客户端和datanode之间的协议接口，用于数据块恢复
		ClientProtocol ：client与Namenode交互的接口，所有控制流的请求均在这里，如：创建文件、删除文件等；
		DatanodeProtocol : Datanode与Namenode交互的接口，如心跳、blockreport等；
		NamenodeProtocol ：SecondaryNode与Namenode交互的接口。
	Mapreduce相关 
		InterDatanodeProtocol ：Datanode内部交互的接口，用来更新block的元数据；
		InnerTrackerProtocol ：TaskTracker与JobTracker交互的接口，功能与DatanodeProtocol相似；
		JobSubmissionProtocol ：JobClient与JobTracker交互的接口，用来提交Job、获得Job等与Job相关的操作；
		TaskUmbilicalProtocol ：Task中子进程与母进程交互的接口，子进程即map、reduce等操作，母进程即TaskTracker，
 * Superclass of all protocols that use Hadoop RPC.
 * Subclasses of this interface are also supposed to have
 * a static final long versionID field.
 */
public interface VersionedProtocol {
  
  /**
   * Return protocol version corresponding to protocol interface.
   * @param protocol The classname of the protocol interface
   * @param clientVersion The version of the protocol that the client speaks
   * @return the version that the server will speak
   */
  public long getProtocolVersion(String protocol, 
                                 long clientVersion) throws IOException;
}
