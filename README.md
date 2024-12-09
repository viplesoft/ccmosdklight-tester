# CCMOSDK Light Version Tester
CCMOSDK Light Version 사용법을 알아보자.

## SDK 개발버전 및 요구사항
- compileSdk = 34
- minSdk = 24
- 설치하려는 앱이 최소 API 24 (Android 7.0) 이상일 경우에만 정상작동이 가능합니다. 

## 설치
### 1. SDK 임포트
- 앱수준의 build.gradle 의 dependencies 블럭내에 아래의 코드를 추가한다.
```
implementation("io.github.viplesoft:ccmosdk-light:0.9.10")
```

### 2. JitPack 설정
- settings.gradle 파일내에 아래의 코드를 추가한다.
```
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven { url = uri("https://www.jitpack.io") }
    }
}
```

### 3. AndroidManifest 설정
- 인터넷에 연결할 수 있는 권한이 필요합니다. 아래의 코드를 추가해주시고 이미 선언되어있다면 스킵하세요.
```
<uses-permission android:name="android.permission.INTERNET" />
```

- sdk내에서 갤러리에 접근하여 사진이나 동영상을 읽거나 쓰는 기능이 포함되어있어 FileProvider 설정이 필요합니다.
  
    application 요소내에 아래의 코드를 삽입합니다.
```
<provider
    android:name="androidx.core.content.FileProvider"
    android:authorities="앱의 패키지명.fileprovider"
    android:exported="false"
    android:grantUriPermissions="true">
    <meta-data
        android:name="android.support.FILE_PROVIDER_PATHS"
        android:resource="@xml/file_paths" />
</provider>
```

### 4. file_paths.xml 설정
- res/xml/file_paths.xml 파일을 생성하고 아래의 내용을 추가한다. 

```
<paths>
    <external-path name="external" path="." />
    <external-cache-path name="external_cache" path="." />
</paths>
```

## SDK 사용
### 1. SDK 초기화

```
val ccmo = CCMO("발급받은 앱키", "앱에서 회원식별이 가능한 ID")
```

### 2. SDK 생성

```
ccmo.create(this)
```

위의 코드가 실행되면 SDK내의 UI 액티비티가 실행되면서 서비스가 시작됩니다. 
