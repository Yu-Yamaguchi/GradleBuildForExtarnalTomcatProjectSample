# レガシーなTomcatプロジェクトを外部のGradleプロジェクトから参照してテスト及びレポーティング自動化

## Overview

システム開発に携わっていると、Java＋ApacheTomcat＋Eclipseの`Tomcatプロジェクト`で構築されたWebアプリケーションを見かけることがよくあります。
そういったシステムの改修案件などがあった場合でも、やはりテストコードは書きたいもの。
テストコードを書いたら、Jenkinsさんとかから実行して、テスト結果などをレポーティングしたい。

そんな希望を実現するために試行錯誤した結果、こういう形式はどーかなーとたどり着いたので公開します。
ソース一式はGitHubで管理しているので、そちらをご利用下さい。
https://github.com/Yu-Yamaguchi/GradleBuildForExtarnalTomcatProjectSample

## サンプルプロジェクトの構成

![キャプチャ.PNG](https://qiita-image-store.s3.amazonaws.com/0/246556/43aad14b-2f38-2703-b056-51325cdb2f2d.png)

- TomcatProject
 - 既存のTomcatプロジェクト
 - Eclipse上の認識が`Tomcatプロジェクト`となってしまっているため、MavenプロジェクトやGradleプロジェクトとして認識させることができない制約がある。（とします）
- TomcatProjectGradle
 - Gradleプロジェクトとして認識されるプロジェクト
 - `TomcatProject`にあるテストコードを実行し、レポート出力する定義などをまとめているプロジェクト
 - このプロジェクトから`TomcatProject`をフラットタイプのマルチプロジェクトとして認識させている

## 反省点

TomcatProject内部にテストコードを書かずに、TomcatProjectGradle側にテストコードを記述することができたかもしれない。（今回のケースでは、テストコードをTomcatProject内に作成することが制約上OKだったので上記構成となっている。）

### やってること

* 外部に設置されたプロジェクトに対するBuild
* JUnitの結果レポート出力
* FindBugsのレポート出力（HTML対応）
* jacocoによるカバレッジレポート出力（HTML対応）

## 使い方

コマンドプロンプトからカレントディレクトリをTomcatProjectGradleに変更して実行してください。

### CI用に全てのタスクを適切な順序で実行する

`gradlew  clean  ci`
このタスクでは、以下のタスクが順番に全て実行されます。

1. clean … 全てのタスク実行前にクリーンする。
1. findbugs … findbugsはcheckタスクの依存関係に標準でセットされているため、check実行時に、先行して実行される。
1. testAll … check.dependsOn += testAllで依存関係をセットしているため、check実行時に、先行して実行される。
1. check … checkstyleの実行
1. checkstyleReport … check実行結果のxmlからHTMLのレポートを出力
1. jacoco … jacocoによるコードカバレッジレポートをHTML形式で出力

### 個別にタスクを実行したい場合

- 指定したTestSuiteのJUnitを実行する。
 - `gradlew testAllTests`

- FindBugsを実行する。
 - `gradlew findbugsTest`

- Checkstyleを実行する→実行後にCheckstyleのレポートを出力する。
 - `gradlew check`
 - `gradlew checkstyleReport`

- jacocoによるカバレッジレポートを出力する。
 - `gradlew jacoco`
