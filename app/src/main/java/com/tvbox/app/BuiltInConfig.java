package com.tvbox.app;

/**
 * 代码内置兜底配置。
 *
 * 存在的理由：assets/config/demo-safe.json 有可能没被打进 APK
 * （例如通过网页上传代码时漏掉了深层目录）。这时如果直接抛异常，
 * 用户看到的就是"读取内置配置失败"和一个空界面，无从下手。
 *
 * 所以这里硬编码一份最小可用配置（只含 Google 公开的示例媒体），
 * 保证 App 无论如何都能起来、能验证播放链路。
 * 用户自己的内容源仍可通过"配置"页填写 URL 加载。
 */
public final class BuiltInConfig {

    private BuiltInConfig() {
    }

    private static final String[] LINES = {
        "{",
        "  \"sites\": [",
        "    {",
        "      \"key\": \"official_samples\",",
        "      \"name\": \"官方测试片源（稳定）\",",
        "      \"type\": \"static\",",
        "      \"searchable\": true,",
        "      \"static\": {",
        "        \"classes\": [",
        "          {\"type_id\": \"mp4\", \"type_name\": \"MP4 直链\"},",
        "          {\"type_id\": \"hls\", \"type_name\": \"HLS 切片\"}",
        "        ],",
        "        \"list\": [",
        "          {",
        "            \"vod_id\": \"gtv-bunny\", \"type_id\": \"mp4\",",
        "            \"vod_name\": \"Big Buck Bunny\",",
        "            \"vod_pic\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg\",",
        "            \"vod_remarks\": \"MP4\",",
        "            \"vod_content\": \"Google 官方公开示例视频，用于验证 MP4 直链播放。\",",
        "            \"vod_play_url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4\"",
        "          },",
        "          {",
        "            \"vod_id\": \"gtv-elephants\", \"type_id\": \"mp4\",",
        "            \"vod_name\": \"Elephants Dream\",",
        "            \"vod_pic\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg\",",
        "            \"vod_remarks\": \"MP4\",",
        "            \"vod_content\": \"Google 官方公开示例视频，用于验证 MP4 直链播放。\",",
        "            \"vod_play_url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4\"",
        "          },",
        "          {",
        "            \"vod_id\": \"gtv-blazes\", \"type_id\": \"mp4\",",
        "            \"vod_name\": \"For Bigger Blazes\",",
        "            \"vod_pic\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg\",",
        "            \"vod_remarks\": \"MP4 · 15s\",",
        "            \"vod_content\": \"Google 官方公开示例视频，短片，加载快，适合快速验证。\",",
        "            \"vod_play_url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4\"",
        "          },",
        "          {",
        "            \"vod_id\": \"exo-hls\", \"type_id\": \"hls\",",
        "            \"vod_name\": \"HLS 多码率测试流\",",
        "            \"vod_pic\": \"\",",
        "            \"vod_remarks\": \"HLS\",",
        "            \"vod_content\": \"ExoPlayer 官方 HLS 测试流，用于验证 m3u8 播放与码率自适应。\",",
        "            \"vod_play_url\": \"https://storage.googleapis.com/exoplayer-test-media-0/Apple/advanced_streaming/hevc/master.m3u8\"",
        "          }",
        "        ]",
        "      }",
        "    }",
        "  ]",
        "}"
    };

    public static String json() {
        StringBuilder sb = new StringBuilder(2048);
        for (String line : LINES) {
            sb.append(line).append('\n');
        }
        return sb.toString();
    }
}
