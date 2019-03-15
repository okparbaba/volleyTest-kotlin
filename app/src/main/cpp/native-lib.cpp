#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_softwarefactory_volleytest_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string apiLink = "https://jsonplaceholder.typicode.com/posts";
    return env->NewStringUTF(apiLink.c_str());
}
